package com.example.simplecalc.model

class Division : Operation() {
    override fun getOperationResult(preservedOperand: Double, currentOperand: Double): Double {
        return preservedOperand / currentOperand
    }
}