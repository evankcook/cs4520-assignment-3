package com.cs4520.assignment3.mvp

class CalculatorPresenterImpl(private var view : CalculatorMVP.CalculatorView?, private var model :
CalculatorMVP.CalculatorModel) : CalculatorMVP.CalculatorPresenter {

    override fun onAddButtonClick(val1 : Double?, val2 : Double?) {
        if (view != null) {
            if (val1 is Double && val2 is Double) {
                view?.showResult(model.add(val1, val2).toString())
            } else {
                view?.showError("All inputs must be present to add.")
            }
        }
    }

    override fun onSubtractButtonClick(val1 : Double?, val2 : Double?) {
        if (view != null) {
            if (val1 is Double && val2 is Double) {
                view?.showResult(model.subtract(val1, val2).toString())
            } else {
                view?.showError("All inputs must be present to subtract.")
            }
        }
    }

    override fun onMultiplyButtonClick(val1 : Double?, val2 : Double?) {
        if (view != null) {
            if (val1 is Double && val2 is Double) {
                view?.showResult(model.multiply(val1, val2).toString())
            } else {
                view?.showError("All inputs must be present to multiply.")
            }
        }
    }

    override fun onDivisionButtonClick(val1 : Double?, val2 : Double?) {
        if (view != null) {
            if (val1 is Double && val2 is Double) {
                view?.showResult(model.division(val1, val2).toString())
            } else {
                view?.showError("All inputs must be present to division.")
            }
        }
    }

    override fun onDestroy() {
        view = null
    }
}