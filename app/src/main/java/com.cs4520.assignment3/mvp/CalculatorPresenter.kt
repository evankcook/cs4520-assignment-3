package com.cs4520.assignment3.mvp

interface CalculatorPresenter {
    fun onAddButtonClick(val1 : Double?, val2 : Double?)
    fun onSubtractButtonClick(val1 : Double?, val2 : Double?)
    fun onMultiplyButtonClick(val1 : Double?, val2 : Double?)
    fun onDivisionButtonClick(val1 : Double?, val2 : Double?)
    fun onDestroy()
}