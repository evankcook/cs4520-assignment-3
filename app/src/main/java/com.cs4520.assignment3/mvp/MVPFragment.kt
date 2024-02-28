package com.cs4520.assignment3.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.CalculatorModelImpl
import com.cs4520.assignment3.databinding.MvpFragmentBinding

class MVPFragment : Fragment(), CalculatorView {
    private var _binding: MvpFragmentBinding? = null
    private val binding get() = _binding!!

    private var presenter: CalculatorPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MvpFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CalculatorPresenterImpl(this, CalculatorModelImpl())
        binding.addButton.setOnClickListener {
            presenter!!.onAddButtonClick(binding.firstInput.text.toString().toDoubleOrNull(),
                binding.secondInput.text.toString().toDoubleOrNull())
            this.clearAllInputs()
        }
        binding.subtractButton.setOnClickListener {
            presenter!!.onSubtractButtonClick(binding.firstInput.text.toString().toDoubleOrNull(),
                binding.secondInput.text.toString().toDoubleOrNull())
            this.clearAllInputs()
        }
        binding.multiplyButton.setOnClickListener {
            presenter!!.onMultiplyButtonClick(binding.firstInput.text.toString().toDoubleOrNull(),
                binding.secondInput.text.toString().toDoubleOrNull())
            this.clearAllInputs()
        }
        binding.divisionButton.setOnClickListener {
            presenter!!.onDivisionButtonClick(binding.firstInput.text.toString().toDoubleOrNull(),
                binding.secondInput.text.toString().toDoubleOrNull())
            this.clearAllInputs()
        }
    }

    override fun onDestroy() {
        presenter!!.onDestroy()
        super.onDestroy()
    }

    override fun showResult(result : String) {
        if (!binding.result.isVisible) {
            binding.result.visibility = View.VISIBLE
        }
        binding.result.text = result
    }

    override fun showError(error : String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        binding.result.visibility = View.GONE
    }

    private fun clearAllInputs() {
        binding.firstInput.text.clear()
        binding.secondInput.text.clear()
    }

}