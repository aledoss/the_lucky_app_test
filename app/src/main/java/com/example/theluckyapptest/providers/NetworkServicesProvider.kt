package com.example.theluckyapptest.providers

import com.example.theluckyapptest.network.OffersApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkServicesProvider {

    private const val BASE_URL = "https://www.nasable.com/"

    private val offersClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideOkHTTPClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOkHTTPClient() = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    fun createOffersApi(): OffersApi =
        offersClient.create(OffersApi::class.java)
}
