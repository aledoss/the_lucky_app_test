package com.example.theluckyapptest.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.theluckyapptest.data.ErrorScreenData

abstract class BaseFragment : Fragment() {
    private var viewListener: BaseViewListener? = null
    protected var shouldShowBackIcon = false

    private fun showBackIcon(show: Boolean) = viewListener?.showBackIcon(show)

    fun showLoading(show: Boolean) = viewListener?.showLoading(show)

    fun updateToolbarTitle(title: String) = viewListener?.updateToolbarTitle(title)

    fun showErrorScreen(errorScreenData: ErrorScreenData) =
        viewListener?.showErrorScreen(errorScreenData)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewListener = context as? BaseViewListener
    }

    override fun onDetach() {
        super.onDetach()
        viewListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBackIcon(shouldShowBackIcon)
    }
}

interface BaseViewListener {
    fun showLoading(showLoading: Boolean)
    fun showBackIcon(show: Boolean)
    fun updateToolbarTitle(title: String)
    fun showErrorScreen(errorData: ErrorScreenData)
}
