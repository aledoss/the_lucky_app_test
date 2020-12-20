package com.example.theluckyapptest.network

import com.example.theluckyapptest.data.OffersResponse
import retrofit2.http.GET

interface OffersApi {

    @GET("luckytest/api/offers")
    suspend fun getOffers(): OffersResponse
}
