package com.github.kiolk.valency

data class Answer(val element: Element, val isConstant: Boolean, val valencies: List<Int>)

fun isCorrectAnswer(answer: Answer): Boolean {
    if (answer.element.isvalencConstantValency != answer.isConstant) return false
    if (answer.valencies.isNotEmpty() && answer.valencies.size == answer.element.valencies.size && answer.valencies.containsAll(answer.element.valencies)) return true
    return false
}