package com.example.theluckyapptest.network

import com.example.theluckyapptest.data.OfferDetails
import com.example.theluckyapptest.data.OffersResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface OffersApi {

    @GET("luckytest/api/offers")
    suspend fun getOffers(): OffersResponse

    @GET
    suspend fun getOffer(@Url offerUrl: String): OfferDetails
}
