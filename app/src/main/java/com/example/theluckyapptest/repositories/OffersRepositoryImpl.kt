package com.example.theluckyapptest.repositories

import com.example.theluckyapptest.data.Offer
import com.example.theluckyapptest.data.OffersSection

class OffersRepositoryImpl : OffersRepository {

    override fun getOffers(): List<OffersSection> {
        return listOf(
            OffersSection(
                "Top Cashbacks",
                listOf(
                    Offer(
                        "https://www.nasable.com/luckytest/api/offers/1",
                        "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1125&h=750&q=80",
                        "Burger Joint",
                        "3,5% Cashbacks Paying with Lucky",
                        "Cashback",
                        283
                    ),
                    Offer(
                        "https://www.nasable.com/luckytest/api/offers/2",
                        "https://images.unsplash.com/photo-1561651823-34feb02250e4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1125&h=750&q=80",
                        "Shawerma El Reem",
                        "4 Sandwiches for 60 EGP Only!",
                        "Discount",
                        1459
                    ),
                    Offer(
                        "https://www.nasable.com/luckytest/api/offers/3",
                        "https://images.unsplash.com/photo-1513104890138-7c749659a591?ixlib=rb-1.2.1&auto=format&fit=crop&w=1125&h=750&q=80",
                        "Pizza King",
                        "Special Combo for 110 EGP only instead of 211 EGP!",
                        "Discount",
                        45
                    )
                )
            ),
            OffersSection(
                "Popular",
                listOf(
                    Offer(
                        "https://www.nasable.com/luckytest/api/offers/5",
                        "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1125&h=750&q=80",
                        "Max Burgers",
                        "Double max burger or double chicken ranch sandwich for EGP 25",
                        "Discount",
                        101
                    )
                )
            )
        )
    }
}