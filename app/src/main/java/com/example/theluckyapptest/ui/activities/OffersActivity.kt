package com.example.theluckyapptest.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.theluckyapptest.R
import com.example.theluckyapptest.databinding.ActivityOffersBinding
import com.example.theluckyapptest.navigation.OffersNavigation
import com.example.theluckyapptest.ui.fragments.OfferDetailsFragment
import com.example.theluckyapptest.ui.fragments.OffersFragment

class OffersActivity : AppCompatActivity(), OffersNavigation {

    private val binding: ActivityOffersBinding by lazy {
        ActivityOffersBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            showOffersFragment()
        }
        supportActionBar?.title = getString(R.string.offers)
    }

    private fun showOffersFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<OffersFragment>(R.id.fragmentContainerView, OffersFragment::class.simpleName)
        }
    }

    override fun goToOfferDetails(offerUrl: String) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            replace<OfferDetailsFragment>(R.id.fragmentContainerView, OfferDetailsFragment::class.simpleName)
        }
    }
}