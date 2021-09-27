package com.example.simplecalc.model

class Number(private val pressed: String, current: String) {
    private val current = if (current.contains("impossible")) "0" else current
    fun getText(): String {
        if (current.length > 16) {
            return current
        }
        return when (pressed) {
            "." -> {
                if (current.contains(".")) current else {
                    current + pressed
                }
            }
            else -> {

                if (current == "0") {
                    pressed
                } else current + pressed
            }
        }
    }

}