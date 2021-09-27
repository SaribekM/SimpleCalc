package com.example.simplecalc.model

abstract class Operation {
    var preservedOperand = 0.0
    var currentOperand = 0.0

    fun execute(): Double {
        return getOperationResult(preservedOperand, currentOperand)
    }

    abstract fun getOperationResult(preservedOperand: Double, currentOperand: Double): Double
}