package com.example.theluckyapptest.data.offersectionsviewtype

import androidx.recyclerview.widget.RecyclerView

const val VIEW_TYPE_HEADER = 1
const val VIEW_TYPE_OFFER = 2

interface OffersSectionsViewType {
    fun getViewType(): Int
    fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder)
}
