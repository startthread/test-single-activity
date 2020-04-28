package com.startthread.singleactivity.confirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.startthread.singleactivity.SharedViewModel
import com.startthread.singleactivity.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {
    data class Result(val value: String)

    companion object {
        const val ARG_INPUT_VALUE = "ARG_INPUT_VALUE"

        const val EXTRA_RESULT_CONFIRMATION = "EXTRA_RESULT_CONFIRMATION"
    }

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: ConfirmationViewModel by viewModels()

    private lateinit var binding: FragmentConfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.doneButton.setOnClickListener {
            val result: Boolean = true
            sharedViewModel.sharedData.value = Pair(EXTRA_RESULT_CONFIRMATION, result)
        }
    }
}
