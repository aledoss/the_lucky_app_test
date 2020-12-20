package com.example.theluckyapptest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.theluckyapptest.R
import com.example.theluckyapptest.data.Offer
import com.example.theluckyapptest.data.offersectionsviewtype.OffersSectionsViewType
import com.example.theluckyapptest.data.offersectionsviewtype.VIEW_TYPE_HEADER
import com.example.theluckyapptest.data.offersectionsviewtype.VIEW_TYPE_OFFER
import com.example.theluckyapptest.databinding.ItemOfferBinding
import com.example.theluckyapptest.databinding.ItemTitleBinding
import com.example.theluckyapptest.extensions.loadFromUrl

class OffersAdapter(private val listener: OnOfferClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var offersSections: List<OffersSectionsViewType> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_HEADER -> TitleViewHolder(
                ItemTitleBinding.inflate(
                    inflater, parent, false
                )
            )
            VIEW_TYPE_OFFER -> OfferViewHolder(
                ItemOfferBinding.inflate(
                    inflater, parent, false
                ),
                listener
            )
            else -> throw Exception("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        offersSections[position].onBindViewHolder(holder)
    }

    override fun getItemCount() = offersSections.size

    override fun getItemViewType(position: Int) =
        offersSections[position].getViewType()

    fun updateOffers(offersSections: List<OffersSectionsViewType>) {
        this.offersSections = offersSections
        notifyDataSetChanged()
    }

    class OfferViewHolder(
        private val itemBinding: ItemOfferBinding,
        private val listener: OnOfferClickListener
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(offer: Offer) {
            itemBinding.apply {
                textViewBrand.text = offer.brand
                textViewDescription.text = offer.title
                textViewTags.text = offer.tags
                textViewFavouriteCount.text = offer.favoriteCount.toString()
                imageViewLogo.loadFromUrl(offer.imageUrl)
                itemView.setOnClickListener { listener.onClick(offer) }
            }
        }
    }

    class TitleViewHolder(
        private val itemBinding: ItemTitleBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(title: String) {
            itemBinding.textViewTitle.text = title
            if (adapterPosition != 0) {
                addMarginTopToRoot()
            }
        }

        private fun addMarginTopToRoot() {
            itemBinding.root.apply {
                val newLayoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
                newLayoutParams.setMargins(
                    0,
                    context.resources.getDimensionPixelSize(R.dimen.spacing_xxlarge),
                    0,
                    0
                )
                layoutParams = newLayoutParams
            }
        }
    }

    fun interface OnOfferClickListener {
        fun onClick(offer: Offer)
    }
}
