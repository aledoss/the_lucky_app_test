package com.example.theluckyapptest.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.theluckyapptest.R
import com.example.theluckyapptest.data.Margin
import com.example.theluckyapptest.data.offersectionsviewtype.OffersSectionsViewType
import com.example.theluckyapptest.databinding.FragmentOffersBinding
import com.example.theluckyapptest.helpers.MarginItemDecoration
import com.example.theluckyapptest.navigation.OffersNavigation
import com.example.theluckyapptest.providers.RepositoryProvider
import com.example.theluckyapptest.ui.adapters.OffersAdapter
import com.example.theluckyapptest.viewmodels.OffersViewModel
import com.example.theluckyapptest.viewmodels.factories.OffersViewModelFactory

class OffersFragment : Fragment() {

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
    }

    private fun updateOffersAdapter(offersSections: List<OffersSectionsViewType>) {
        adapter.updateOffers(offersSections)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
