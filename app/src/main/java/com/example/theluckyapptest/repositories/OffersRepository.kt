package com.example.theluckyapptest.repositories

import com.example.theluckyapptest.data.OfferDetails
import com.example.theluckyapptest.data.offersectionsviewtype.OffersSectionsViewType

interface OffersRepository {
    suspend fun getOffersSections(): OffersSectionsViewType
    suspend fun getOfferDetails(offerUrl: String): OfferDetails
}