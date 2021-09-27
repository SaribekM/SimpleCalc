package com.example.simplecalc.model

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


class Calculator (val preservedOperand: String,val currentOperand: String,val operator: String) {

    fun result(): String {
        val operation: Operation = OperationFactory.getOperation(operator)!!
        operation.preservedOperand= textToDouble(preservedOperand)
        operation.currentOperand = textToDouble(currentOperand)
        val result = operation.execute()
        return resultToString(result)
    }

    companion object {
        private fun textToDouble(text: String): Double {
            val result = text.replace("[^-0-9.E]".toRegex(), "")
            if (result.isEmpty()) return 0.0
            val d = result.toDouble()
            return d + 0
        }
        private fun resultToString(d:Double):String{

            if (d.isNaN() || d.isInfinite()) return "impossible"

            val df = DecimalFormat("#,###.##########")
            val dfs = DecimalFormatSymbols()
            dfs.groupingSeparator=' '
            df.decimalFormatSymbols=dfs
            val result:String=df.format(d)
            if (result.equals("-0"))return "0"

            val withScientificSeparator = DecimalFormat("0.########E0")
            if (result.length>15){
                val wss = result.replace("[^-0-9.]".toRegex(), "").toDouble()
                return withScientificSeparator.format(wss)
            }
            return result
        }
    }
}