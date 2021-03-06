package com.startthread.singleactivity.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.startthread.singleactivity.SharedViewModel
import com.startthread.singleactivity.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    data class Result(val value: String)

    companion object {
        const val ARG_INPUT_VALUE = "ARG_INPUT_VALUE"

        const val EXTRA_RESULT_SECOND = "EXTRA_RESULT_SECOND"
    }

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: SecondViewModel by viewModels()

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.doneButton.setOnClickListener {
            val result = Result(binding.textInputLayout.editText?.text.toString())

            sharedViewModel.sharedData.value = Pair(EXTRA_RESULT_SECOND, result)
        }
    }
}

