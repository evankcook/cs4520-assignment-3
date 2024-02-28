package com.cs4520.assignment3.mvp

import com.cs4520.assignment3.CalculatorModel

class CalculatorPresenterImpl(private var view : CalculatorView?, private var model :
CalculatorModel) : CalculatorPresenter {


    override fun onAddButtonClick(val1: Double?, val2: Double?) {
        if (val1 == null || val2 == null) {
            view?.showError("All inputs must be present to add.")
        } else {
            view?.showResult(model.add(val1, val2).toString())
        }
    }

    override fun onSubtractButtonClick(val1: Double?, val2: Double?) {
        if (val1 == null || val2 == null) {
            view?.showError("All inputs must be present to subtract.")
        } else {
            view?.showResult(model.subtract(val1, val2).toString())
        }
    }

    override fun onMultiplyButtonClick(val1: Double?, val2: Double?) {
        if (val1 == null || val2 == null) {
            view?.showError("All inputs must be present to multiply.")
        } else {
            view?.showResult(model.multiply(val1, val2).toString())
        }
    }

    override fun onDivisionButtonClick(val1: Double?, val2: Double?) {
        if (val1 == null || val2 == null) {
            view?.showError("All inputs must be present to perform division.")
        } else if (val2 == 0.0) {
            view?.showError("Cannot divide by zero.")
        } else {
            view?.showResult(model.division(val1, val2).toString())
        }
    }

    override fun onDestroy() {
        view = null
    }
}