package com.example.theluckyapptest.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.example.theluckyapptest.R

class OfferDetailsFragment : Fragment(R.layout.fragment_offer_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
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

}