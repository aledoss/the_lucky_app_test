package com.example.theluckyapptest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.theluckyapptest.databinding.FragmentOffersBinding
import com.example.theluckyapptest.viewmodels.OffersViewModel
import com.example.theluckyapptest.viewmodels.OffersViewModelFactory

class OffersFragment : Fragment() {

    private val viewModel: OffersViewModel by viewModels {
        OffersViewModelFactory()
    }

    private var _binding: FragmentOffersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOffersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}