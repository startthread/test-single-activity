package com.startthread.singleactivity.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.startthread.singleactivity.SharedViewModel
import com.startthread.singleactivity.confirmation.ConfirmationViewModel
import com.startthread.singleactivity.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    data class Result(val value: String)

    companion object {
        const val EXTRA_RESULT_FIRST = "EXTRA_RESULT_FIRST"
    }

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: ConfirmationViewModel by viewModels()

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.doneButton.setOnClickListener {
            val result = Result(binding.textInputLayout.editText?.text.toString())
            sharedViewModel.sharedData.value = Pair(EXTRA_RESULT_FIRST, result)
        }
    }
}
