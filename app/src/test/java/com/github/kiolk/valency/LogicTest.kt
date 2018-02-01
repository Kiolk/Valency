package com.github.kiolk.valency

import org.junit.Assert
import org.junit.Test

class LogicTest {
    @Test
    fun checkAnswer() {

        Assert.assertTrue(isCorrectAnswer(Answer(getElement("Sodium"), true, listOf(1))))
        Assert.assertFalse(isCorrectAnswer(Answer(getElement("Iron"), false, listOf(2, 4))))
        Assert.assertTrue(isCorrectAnswer(Answer(getElement("Chlorine"), false, listOf(1, 3, 5, 7))))
    }
}