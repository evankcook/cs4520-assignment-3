package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.CalculatorModel
import com.cs4520.assignment3.CalculatorModelImpl

class CalculatorViewModel : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result : LiveData<String> = _result
    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error
    private val model : CalculatorModel = CalculatorModelImpl()

    fun onAddButtonClick(val1: Double?, val2: Double?) {
        if (val1 == null || val2 == null) {
            _error.value = "All inputs must be present to add."
        } else {
            _result.value = model.add(val1, val2).toString()
        }
    }

    fun onSubtractButtonClick(val1: Double?, val2: Double?) {
        if (val1 == null || val2 == null) {
            _error.value = "All inputs must be present to subtract."
        } else {
            _result.value = model.subtract(val1, val2).toString()
        }
    }

    fun onMultiplyButtonClick(val1: Double?, val2: Double?) {
        if (val1 == null || val2 == null) {
            _error.value = "All inputs must be present to multiply."
        } else {
            _result.value = model.multiply(val1, val2).toString()
        }
    }

    fun onDivisionButtonClick(val1: Double?, val2: Double?) {
        if (val1 == null || val2 == null) {
            _error.value = "All inputs must be present to perform division."
        } else if (val2 == 0.0) {
            _error.value = "Cannot divide by zero."
        } else {
            _result.value = model.division(val1, val2).toString()
        }
    }




}