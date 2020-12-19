package com.example.theluckyapptest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.theluckyapptest.databinding.ActivityOffersBinding
import com.example.theluckyapptest.ui.OffersFragment

class OffersActivity : AppCompatActivity() {

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
}