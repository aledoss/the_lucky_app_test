package com.example.theluckyapptest.data.offersectionsviewtype

import androidx.recyclerview.widget.RecyclerView
import com.example.theluckyapptest.data.Offer
import com.example.theluckyapptest.ui.adapters.OffersAdapter

class OfferViewType(private val offer: Offer) : OfferSectionViewType {
    override fun getViewType() = VIEW_TYPE_OFFER

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        (viewHolder as OffersAdapter.OfferViewHolder).bind(offer)
    }
}
