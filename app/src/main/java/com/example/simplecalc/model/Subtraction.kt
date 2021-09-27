package com.example.simplecalc.model

class Subtraction : Operation() {
    override fun getOperationResult(preservedOperand: Double, currentOperand: Double): Double {
        return preservedOperand - currentOperand
    }
}