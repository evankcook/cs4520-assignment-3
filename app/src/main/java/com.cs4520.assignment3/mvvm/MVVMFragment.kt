package com.cs4520.assignment3.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.databinding.MvvmFragmentBinding
import com.cs4520.assignment3.mvp.CalculatorPresenter

class MVVMFragment : Fragment() {
    private var _binding: MvvmFragmentBinding? = null
    private val binding get() = _binding!!
    private var viewModel: CalculatorViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MvvmFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        binding.addButton.setOnClickListener {
            viewModel!!.onAddButtonClick(binding.firstInput.text.toString().toDoubleOrNull(),
                binding.secondInput.text.toString().toDoubleOrNull())
            this.clearAllInputs()
        }
        binding.subtractButton.setOnClickListener {
            viewModel!!.onSubtractButtonClick(binding.firstInput.text.toString().toDoubleOrNull(),
                binding.secondInput.text.toString().toDoubleOrNull())
            this.clearAllInputs()
        }
        binding.multiplyButton.setOnClickListener {
            viewModel!!.onMultiplyButtonClick(binding.firstInput.text.toString().toDoubleOrNull(),
                binding.secondInput.text.toString().toDoubleOrNull())
            this.clearAllInputs()
        }
        binding.divisionButton.setOnClickListener {
            viewModel!!.onDivisionButtonClick(binding.firstInput.text.toString().toDoubleOrNull(),
                binding.secondInput.text.toString().toDoubleOrNull())
            this.clearAllInputs()
        }
        this.initObserver()
    }

    private fun initObserver() {

        viewModel?.result?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                if (!binding.result.isVisible) {
                    binding.result.visibility = View.VISIBLE
                }
                binding.result.text = it
            } else {
                Toast.makeText(requireContext(), "Error Calculating Result", Toast.LENGTH_LONG)
                    .show()
            }
        })

        viewModel?.error?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                binding.result.visibility = View.GONE
            } else {
                Toast.makeText(requireContext(), "An Error occurred...", Toast.LENGTH_LONG)
                    .show()
            }
        })

    }

    private fun clearAllInputs() {
        binding.firstInput.text.clear()
        binding.secondInput.text.clear()
    }

}