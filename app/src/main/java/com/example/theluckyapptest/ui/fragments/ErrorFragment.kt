package com.example.theluckyapptest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.theluckyapptest.data.ErrorScreenData
import com.example.theluckyapptest.databinding.FragmentErrorBinding

class ErrorFragment : BaseFragment() {

    private var errorData: ErrorScreenData? = null
    private var _binding: FragmentErrorBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shouldShowBackIcon = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentErrorBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateToolbarTitle("")
        setHasOptionsMenu(true)
        errorData = arguments?.get(ERROR_DATA) as ErrorScreenData
        bindUI()
    }

    private fun bindUI() {
        binding.apply {
            errorData?.let { errorData ->
                textViewTitle.text = getString(errorData.title)
                textViewDescription.text = getString(errorData.message)
                buttonRetry.setOnClickListener {
                    requireActivity().supportFragmentManager.popBackStack()
                    errorData.retryAction()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            requireActivity().finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ERROR_DATA = "ERROR_DATA"

        fun newInstance(errorData: ErrorScreenData): ErrorFragment {
            return ErrorFragment().apply {
                arguments = bundleOf(ERROR_DATA to errorData)
            }
        }
    }
}
