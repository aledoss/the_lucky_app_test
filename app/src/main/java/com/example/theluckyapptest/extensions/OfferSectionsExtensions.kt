package com.example.theluckyapptest.extensions

import com.example.theluckyapptest.data.OffersSection
import com.example.theluckyapptest.data.offersectionsviewtype.OfferSectionViewType
import com.example.theluckyapptest.data.offersectionsviewtype.OfferViewType
import com.example.theluckyapptest.data.offersectionsviewtype.SectionViewType

fun List<OffersSection>.toOfferSectionsViewType(): List<OfferSectionViewType> {
    val offersSections = mutableListOf<OfferSectionViewType>()
    this.forEach {
        offersSections.add(SectionViewType(it.title))
        it.offers.forEach { offer ->
            offersSections.add(OfferViewType(offer))
        }
    }
    return offersSections
}
