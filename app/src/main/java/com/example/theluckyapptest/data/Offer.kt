package com.example.theluckyapptest.data

data class OffersResponse(
    val sections: List<OffersSection>
)

data class OffersSection(
    val title: String,
    val offers: List<Offer>
)

data class Offer(
    val detailUrl: String,
    val imageUrl: String,
    val brand: String,
    val title: String,
    val tags: String,
    val favoriteCount: Int
)