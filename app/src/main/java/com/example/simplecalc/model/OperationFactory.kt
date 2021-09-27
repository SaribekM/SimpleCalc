package com.example.simplecalc.model

class OperationFactory {

    companion object {
        private val operationMap = mutableMapOf<String, Operation?>(
            "+" to Addition(),
            "−" to Subtraction(),
            "x" to Multiplication(),
            "÷" to Division(),
        )

        fun getOperation(operation: String): Operation? {
            return operationMap[operation]
        }
    }


}
