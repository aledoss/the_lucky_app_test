package com.example.theluckyapptest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.theluckyapptest.data.ErrorScreenData
import com.example.theluckyapptest.data.OfferDetails
import com.example.theluckyapptest.data.Price
import com.example.theluckyapptest.repositories.OffersRepository
import com.example.theluckyapptest.viewmodels.OfferDetailsViewModel
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
class OfferDetailsViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var offersRepository: OffersRepository

    @Mock
    lateinit var loadingObserver: Observer<Boolean>

    @Mock
    lateinit var offerDetailsObserver: Observer<OfferDetails>

    @Mock
    lateinit var isOfferInvalidObserver: Observer<Boolean>

    @Mock
    lateinit var errorScreenDataObserver: Observer<ErrorScreenData>

    private val validOfferUrl = "www.nico.com"

    private val invalidOfferUrl = ""

    private val offerDetails = OfferDetails(
        id = 1,
        imageUrl = "imageurl.com",
        brand = "",
        title = "",
        tags = "",
        favoriteCount = 1,
        description = "",
        price = Price("", ""),
        expiration = "",
        redemptionCap = ""
    )

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `given loading state and a valid offerUrl, when viewModel is initialized, then loading state changed to true`() {
        runBlocking {
            initViewModelWithValidUrl()
            verify(loadingObserver).onChanged(true)
        }
    }

    @Test
    fun `given loading state and a valid offerUrl, when viewModel is initialized, then loading state changed to false`() {
        runBlocking {
            initViewModelWithValidUrl()
            delay(800)
            verify(loadingObserver).onChanged(false)
        }
    }

    @Test
    fun `given success state and a valid offerUrl, when viewModel is initialized, then offerDetails changed to offerDetails value`() {
        runBlocking {
            initViewModelWithValidUrl()
            delay(2500)
            verify(offerDetailsObserver).onChanged(offerDetails)
        }
    }

    @Test
    fun `given an invalid offerUrl, when viewModel is initialized, then isOfferInvalid changed to true`() {
        initViewModelWithInvalidUrl()
        verify(isOfferInvalidObserver).onChanged(true)
    }

    @Test
    fun `given error state, when viewModel is initialized, then errorScreenData changed`() {
        runBlocking {
            initViewModelWithException()
            delay(500)
            verify(errorScreenDataObserver).onChanged(any())
        }
    }

    private suspend fun initViewModelWithValidUrl() {
        `when`(offersRepository.getOfferDetails(validOfferUrl)).thenReturn(offerDetails)
        createViewModel(validOfferUrl)
    }

    private fun initViewModelWithInvalidUrl() {
        createViewModel(invalidOfferUrl)
    }

    private suspend fun initViewModelWithException() {
        `when`(offersRepository.getOfferDetails(validOfferUrl)).then { throw Exception("I'm an exception :D") }
        createViewModel(validOfferUrl)
    }

    private fun createViewModel(offerUrl: String) =
        OfferDetailsViewModel(offersRepository, offerUrl).apply {
            getShowLoading.observeForever(loadingObserver)
            offerDetails.observeForever(offerDetailsObserver)
            isOfferInvalid.observeForever(isOfferInvalidObserver)
            getErrorScreenData.observeForever(errorScreenDataObserver)
        }
}
