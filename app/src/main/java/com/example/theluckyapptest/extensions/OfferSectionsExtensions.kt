package com.example.theluckyapptest.extensions

import com.example.theluckyapptest.data.OffersSection
import com.example.theluckyapptest.data.offersectionsviewtype.OfferSectionViewType
import com.example.theluckyapptest.data.offersectionsviewtype.OfferViewType
import com.example.theluckyapptest.data.offersectionsviewtype.OffersSectionsViewType
import com.example.theluckyapptest.data.offersectionsviewtype.SectionViewType

fun List<OffersSection>.toOfferSectionsViewType(): OffersSectionsViewType {
    val offersSections = mutableListOf<OfferSectionViewType>()
    var offersQuantity = 0
    this.forEach {
        offersSections.add(SectionViewType(it.title))
        it.offers.forEach { offer ->
            offersSections.add(OfferViewType(offer))
            offersQuantity++
        }
    }
    return OffersSectionsViewType(offersQuantity, offersSections)
}
