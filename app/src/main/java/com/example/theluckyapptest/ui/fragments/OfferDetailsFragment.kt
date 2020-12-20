package com.example.theluckyapptest.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.theluckyapptest.R
import com.example.theluckyapptest.providers.RepositoryProvider
import com.example.theluckyapptest.viewmodels.OfferDetailsViewModel
import com.example.theluckyapptest.viewmodels.factories.OfferDetailsViewModelFactory

class OfferDetailsFragment : Fragment(R.layout.fragment_offer_details) {

    private val viewModel: OfferDetailsViewModel by viewModels {
        OfferDetailsViewModelFactory(
            arguments?.get(OFFER_URL).toString(),
            RepositoryProvider.offersRepository
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_offer_details, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_share -> logEvent("Share menu item was clicked")
            R.id.item_favourite -> logEvent("Favourite menu item  was clicked")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logEvent(text: String) = Log.i(OfferDetailsFragment::class.simpleName, text)

    companion object {
        private const val OFFER_URL = "offer_url"

        fun newInstance(offerUrl: String): OfferDetailsFragment {
            return OfferDetailsFragment().apply {
                arguments = bundleOf(OFFER_URL to offerUrl)
            }
        }
    }
}