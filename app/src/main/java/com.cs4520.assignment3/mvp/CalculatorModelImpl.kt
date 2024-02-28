package com.cs4520.assignment3.mvp

class CalculatorModelImpl : CalculatorMVP.CalculatorModel {
    override fun add(val1 : Double, val2 : Double) : Double {
        return val1 + val2
    }

    override fun subtract(val1 : Double, val2 : Double) : Double {
        return val1 - val2
    }

    override fun multiply(val1 : Double, val2 : Double) : Double {
        return val1 * val2
    }

    override fun division(val1 : Double, val2 : Double) : Double {
        return val1 / val2
    }

}