package com.example.theluckyapptest.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.theluckyapptest.R
import com.example.theluckyapptest.databinding.FragmentOfferDetailsBinding
import com.example.theluckyapptest.providers.RepositoryProvider
import com.example.theluckyapptest.viewmodels.OfferDetailsViewModel
import com.example.theluckyapptest.viewmodels.factories.OfferDetailsViewModelFactory

class OfferDetailsFragment : BaseFragment() {

    private var _binding: FragmentOfferDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: OfferDetailsViewModel by viewModels {
        OfferDetailsViewModelFactory(
            arguments?.get(OFFER_URL).toString(),
            RepositoryProvider.offersRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shouldShowBackIcon = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOfferDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setHasOptionsMenu(true)
        updateToolbarTitle(getString(R.string.offer))
    }

    private fun bindViewModel() {
        viewModel.getShowLoading.observe(viewLifecycleOwner, Observer(::showLoading))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_offer_details, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_share -> logEvent("Share menu item was clicked")
            R.id.item_favourite -> logEvent("Favourite menu item  was clicked")
            android.R.id.home -> closeScreen()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun closeScreen() {
        requireActivity().supportFragmentManager.popBackStack()
    }

    private fun logEvent(text: String) = Log.i(OfferDetailsFragment::class.simpleName, text)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val OFFER_URL = "offer_url"

        fun newInstance(offerUrl: String): OfferDetailsFragment {
            return OfferDetailsFragment().apply {
                arguments = bundleOf(OFFER_URL to offerUrl)
            }
        }
    }
}