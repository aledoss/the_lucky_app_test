package com.example.theluckyapptest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.theluckyapptest.data.ErrorScreenData
import com.example.theluckyapptest.data.offersectionsviewtype.OfferSectionViewType
import com.example.theluckyapptest.repositories.OffersRepository
import com.example.theluckyapptest.viewmodels.OffersViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.any
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class OffersViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var offersRepository: OffersRepository

    @Mock
    lateinit var loadingObserver: Observer<Boolean>

    @Mock
    lateinit var offerSectionObserver: Observer<List<OfferSectionViewType>>

    @Mock
    lateinit var errorScreenDataObserver: Observer<ErrorScreenData>

    private val offerSectionViewType: List<OfferSectionViewType> = listOf(
        object : OfferSectionViewType {
            override fun getViewType() = 0
            override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) = Unit
        }
    )

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `given loading state, when viewModel is initialized, then loading state changed to true`() {
        runBlocking {
            initViewModel()
            verify(loadingObserver).onChanged(true)
        }
    }

    @Test
    fun `given loading state, when viewModel is initialized, then loading state changed to false`() {
        runBlocking {
            initViewModel()
            delay(800)
            verify(loadingObserver).onChanged(false)
        }
    }

    @Test
    fun `given success state, when viewModel is initialized, then offersSections changed to offersSectionsViewType value`() {
        runBlocking {
            initViewModel()
            delay(3500)
            verify(offerSectionObserver).onChanged(offerSectionViewType)
        }
    }

    @Test
    fun `given error state, when viewModel is initialized, then errorScreenData changed`() {
        runBlocking {
            initViewModelWithException()
            delay(500)
            verify(errorScreenDataObserver).onChanged(any())
        }
    }

    private suspend fun initViewModel() {
        `when`(offersRepository.getOffersSections()).thenReturn(offerSectionViewType)
        createViewModel()
    }

    private suspend fun initViewModelWithException() {
        `when`(offersRepository.getOffersSections()).then { throw Exception("") }
        createViewModel()
    }

    private fun createViewModel() = OffersViewModel(offersRepository).apply {
        getShowLoading.observeForever(loadingObserver)
        offerSections.observeForever(offerSectionObserver)
        getErrorScreenData.observeForever(errorScreenDataObserver)
    }
}
