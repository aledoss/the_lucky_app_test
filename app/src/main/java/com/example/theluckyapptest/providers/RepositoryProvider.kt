package com.example.theluckyapptest.providers

import com.example.theluckyapptest.repositories.OffersRepositoryImpl

object RepositoryProvider {
    val offersRepository = OffersRepositoryImpl()
}