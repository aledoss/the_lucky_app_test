package com.example.theluckyapptest.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.theluckyapptest.R
import com.example.theluckyapptest.data.ErrorScreenData
import com.example.theluckyapptest.databinding.ActivityOffersBinding
import com.example.theluckyapptest.extensions.hide
import com.example.theluckyapptest.extensions.show
import com.example.theluckyapptest.navigation.OffersNavigation
import com.example.theluckyapptest.ui.fragments.BaseViewListener
import com.example.theluckyapptest.ui.fragments.OfferDetailsFragment
import com.example.theluckyapptest.ui.fragments.OffersFragment

class OffersActivity : AppCompatActivity(), OffersNavigation, BaseViewListener {

    private val binding: ActivityOffersBinding by lazy {
        ActivityOffersBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            showOffersFragment()
        }
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
            replace(
                R.id.fragmentContainerView,
                OfferDetailsFragment.newInstance(offerUrl),
                OfferDetailsFragment::class.simpleName
            )
        }
    }

    override fun showLoading(show: Boolean) {
        val visibility = if (show) View.VISIBLE else View.GONE
        binding.layoutLoaders.visibility = visibility
    }

    override fun showBackIcon(show: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(show)
    }

    override fun updateToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun showErrorScreen(errorData: ErrorScreenData) {
        binding.apply {
            fragmentContainerView.hide()
            layoutErrorScreen.root.show()
            layoutErrorScreen.textViewTitle.text = getString(errorData.title)
            layoutErrorScreen.textViewDescription.text = getString(errorData.message)
            layoutErrorScreen.buttonRetry.setOnClickListener {
                errorData.retryAction()
                root.hide()
                fragmentContainerView.show()
            }
        }
    }
}
