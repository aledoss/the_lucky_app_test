package com.example.theluckyapptest.repositories

import com.example.theluckyapptest.data.OffersSection

interface OffersRepository {
    fun getOffers(): OffersSection
}