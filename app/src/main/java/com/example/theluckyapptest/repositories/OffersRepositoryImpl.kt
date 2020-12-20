package com.example.theluckyapptest.repositories

import com.example.theluckyapptest.data.offersectionsviewtype.OffersSectionsViewType
import com.example.theluckyapptest.extensions.toOfferSectionsViewType
import com.example.theluckyapptest.network.OffersApi

class OffersRepositoryImpl(
    private val offersApi: OffersApi
) : OffersRepository {

    override suspend fun getOffersSections(): List<OffersSectionsViewType> {
        return offersApi
            .getOffers()
            .sections
            .toOfferSectionsViewType()
    }
}
