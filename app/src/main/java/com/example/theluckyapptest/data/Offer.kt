package com.example.theluckyapptest.data

import com.google.gson.annotations.SerializedName

data class OffersResponse(
    @SerializedName("sections")
    val sections: List<OffersSection>
)

data class OffersSection(
    @SerializedName("title")
    val title: String,
    @SerializedName("items")
    val offers: List<Offer>
)

data class Offer(
    @SerializedName("detailUrl")
    val detailUrl: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("tags")
    val tags: String,
    @SerializedName("favoriteCount")
    val favoriteCount: Int
)
