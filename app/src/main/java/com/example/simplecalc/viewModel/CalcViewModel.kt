package com.example.simplecalc.viewModel

import com.example.simplecalc.model.Calculator
import com.example.simplecalc.model.Number

class CalcViewModel {

    private var preservedOperator = "="
    private var preservedValueText = "0"
    private var secondValueText = "0"
    lateinit var currentText: String
    lateinit var currentButton: String

    fun getNumber(): String {
        if (preservedOperator.equals("=")) {
            val number =
                Number(pressed = currentButton, current = preservedValueText)
            preservedValueText = number.getText()
            return preservedValueText
        } else {
            val number =
                Number(pressed = currentButton, current = secondValueText)
            secondValueText = number.getText()

            return secondValueText
        }
    }

    fun resetAll(): String {
        preservedOperator = "="
        preservedValueText = "0"
        return "0"
    }

    fun getOperationResult(): String {
        preservedOperator = currentButton
        preservedValueText = currentText
        secondValueText = "0"
        return currentText

    }

    fun getCalculationResult(): String {
        if (preservedOperator.equals("=")) {
            return currentText
        } else {
            val calc = Calculator(
                preservedOperand = preservedValueText,
                currentOperand = secondValueText,
                operator = preservedOperator
            )

            preservedOperator = "="
            preservedValueText = "0"
            return calc.result()
        }
    }
}