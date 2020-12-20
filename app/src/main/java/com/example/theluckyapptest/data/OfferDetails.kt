package com.example.theluckyapptest.data

import com.google.gson.annotations.SerializedName

data class OfferDetails(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("tags")
    val tags: String,
    @SerializedName("favoriteCount")
    val favoriteCount: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Price,
    @SerializedName("expiration")
    val expiration: String,
    @SerializedName("redemptionsCap")
    val redemptionCap: String
)

data class Price(
    @SerializedName("old")
    val old: String,
    @SerializedName("new")
    val new: String
)
