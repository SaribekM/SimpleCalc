package com.example.simplecalc.model

class Multiplication : Operation() {
    override fun getOperationResult(preservedOperand: Double, currentOperand: Double): Double {
        return preservedOperand * currentOperand
    }
}