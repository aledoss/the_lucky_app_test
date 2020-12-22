package com.example.theluckyapptest.data.offersectionsviewtype

import androidx.recyclerview.widget.RecyclerView
import com.example.theluckyapptest.ui.adapters.OffersAdapter

class SectionViewType(private val title: String) : OfferSectionViewType {
    override fun getViewType() = VIEW_TYPE_HEADER

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        (viewHolder as OffersAdapter.TitleViewHolder).bind(title)
    }
}
