package com.startthread.singleactivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import com.startthread.singleactivity.confirmation.ConfirmationFragment
import com.startthread.singleactivity.databinding.ActivityMainBinding
import com.startthread.singleactivity.first.FirstFragment
import com.startthread.singleactivity.second.SecondFragment

class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupLiveData()
    }

    private fun setupLiveData() {
        sharedViewModel.sharedData.observe(this, Observer {
            when (it.first) {
                FirstFragment.EXTRA_RESULT_FIRST -> {
                    handleFIrstFragmentResult(it)
                }

                SecondFragment.EXTRA_RESULT_SECOND -> {
                    handleSecondFragmentResult(it)
                }

                ConfirmationFragment.EXTRA_RESULT_CONFIRMATION -> {
                    handleConfirmationFragmentResult(it)
                }
            }
        })
    }

    private fun handleConfirmationFragmentResult(it: Pair<String, Any>) {
        val result = it.second as Boolean
        if (result) {
            finish()
        }
    }

    private fun handleSecondFragmentResult(it: Pair<String, Any>) {
        val result = it.second as SecondFragment.Result
        updateResult(it.first, result.value)

        val bundle = bundleOf(Pair(ConfirmationFragment.ARG_INPUT_VALUE, result.value))
        findNavController(
            this,
            R.id.nav_host_fragment
        ).navigate(R.id.action_to_confirmationFragment, bundle)
    }

    private fun handleFIrstFragmentResult(it: Pair<String, Any>) {
        val result = it.second as FirstFragment.Result
        updateResult(it.first, result.value)

        val bundle = bundleOf(Pair(SecondFragment.ARG_INPUT_VALUE, result.value))
        findNavController(this, R.id.nav_host_fragment).navigate(
            R.id.action_to_secondFragment,
            bundle
        )
    }

    private fun updateResult(key: String, value: String) {
        binding.textView.text = binding.textView.text.toString() + "\n" + "$key = $value"
    }
}
