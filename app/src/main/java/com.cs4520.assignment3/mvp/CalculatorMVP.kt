package com.cs4520.assignment3.mvp

interface CalculatorMVP {
    interface CalculatorModel {
        fun add(val1 : Double, val2 : Double) : Double
        fun subtract(val1 : Double, val2 : Double) : Double
        fun multiply(val1 : Double, val2 : Double) : Double
        fun division(val1 : Double, val2 : Double): Double
    }

    interface CalculatorView {
        fun showResult(result : String)
        fun showError(error : String)
    }

    interface CalculatorPresenter {
        fun onAddButtonClick(val1 : Double?, val2 : Double?)
        fun onSubtractButtonClick(val1 : Double?, val2 : Double?)
        fun onMultiplyButtonClick(val1 : Double?, val2 : Double?)
        fun onDivisionButtonClick(val1 : Double?, val2 : Double?)
        fun onDestroy()
    }
}