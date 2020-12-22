package com.example.theluckyapptest.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.theluckyapptest.R
import com.example.theluckyapptest.data.Margin
import com.example.theluckyapptest.data.offersectionsviewtype.OfferSectionViewType
import com.example.theluckyapptest.databinding.FragmentOffersBinding
import com.example.theluckyapptest.helpers.MarginItemDecoration
import com.example.theluckyapptest.navigation.OffersNavigation
import com.example.theluckyapptest.providers.RepositoryProvider
import com.example.theluckyapptest.ui.adapters.OffersAdapter
import com.example.theluckyapptest.viewmodels.OffersViewModel
import com.example.theluckyapptest.viewmodels.factories.OffersViewModelFactory

class OffersFragment : BaseFragment() {

    private val viewModel: OffersViewModel by viewModels {
        OffersViewModelFactory(RepositoryProvider.offersRepository)
    }
    private val adapter = OffersAdapter {
        navigationListener?.goToOfferDetails(it.detailUrl)
    }

    private var navigationListener: OffersNavigation? = null
    private var _binding: FragmentOffersBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationListener = context as? OffersNavigation
    }

    override fun onDetach() {
        super.onDetach()
        navigationListener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOffersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        configureRecyclerView()
        updateToolbarTitle(getString(R.string.offers))
    }

    private fun configureRecyclerView() {
        binding.recyclerViewOffers.apply {
            adapter = this@OffersFragment.adapter
            addItemDecoration(
                MarginItemDecoration(
                    Margin(resources.getDimensionPixelSize(R.dimen.spacing_xxlarge))
                )
            )
        }
    }

    private fun bindViewModel() {
        viewModel.offerSections.observe(viewLifecycleOwner, Observer(::updateOffersAdapter))
        viewModel.offersQuantity.observe(viewLifecycleOwner, Observer(::updateOffersQuantity))
        viewModel.getShowLoading.observe(viewLifecycleOwner, Observer(::showLoading))
        viewModel.getErrorScreenData.observe(viewLifecycleOwner, Observer(::showErrorScreen))
    }

    private fun updateOffersAdapter(offersSections: List<OfferSectionViewType>) {
        adapter.updateOffers(offersSections)
    }

    private fun updateOffersQuantity(quantity: Int) {
        binding.textViewOffersQuantity.text =
            resources.getQuantityString(R.plurals.numberOfOffers, quantity, quantity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
