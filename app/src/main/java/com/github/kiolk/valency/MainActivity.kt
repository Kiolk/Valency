package com.github.kiolk.valency

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.kiolk.animation.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var codedElement: Element
    lateinit var answer: Answer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAskedElement()

        check_result_button.setOnClickListener {
            formAnswer()
//            answer_text_view.text = isCorrectAnswer(answer).toString()

            when {
                isCorrectAnswer(answer) -> {
                    answer_text_view.text = getString(R.string.CORRECT)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        answer_text_view.background = resources.getDrawable(R.drawable.round)
                    }
                    setAskedElement()
                }
                check_result_button.text == getString(R.string.NEXT_ELEMENT) -> {
                    setAskedElement()
                    check_result_button.text = getString(R.string.CHECK_RESULT)
                }
                else -> {
                    answer_text_view.text = getString(R.string.WRONG)
                    answer_text_view.setBackgroundColor(Color.RED)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        answer_text_view.background = resources.getDrawable(R.drawable.round_wrong)
                    }
                    showCorrectAnswer()
                    check_result_button.text = getString(R.string.NEXT_ELEMENT)
                }
            }
        }
    }

    private fun showCorrectAnswer() {
        showWrongAnswer()
        if (codedElement.isvalencConstantValency) {
//            constant_valency_radio_button.isChecked
            constant_valency_radio_button.setBackgroundColor(Color.GREEN)
        } else {
//            variable_valency_radio_button.isChecked
            variable_valency_radio_button.setBackgroundColor(Color.GREEN)
        }
        if (codedElement.valencies.find { it == 1 } == 1) valency_one_check_box.setBackgroundColor(Color.GREEN)
        if (codedElement.valencies.find { it == 2 } == 2) valency_two_check_box.setBackgroundColor(Color.GREEN)
        if (codedElement.valencies.find { it == 3 } == 3) valency_three_check_box.setBackgroundColor(Color.GREEN)
        if (codedElement.valencies.find { it == 4 } == 4) valency_four_check_box.setBackgroundColor(Color.GREEN)
        if (codedElement.valencies.find { it == 5 } == 5) valency_five_check_box.setBackgroundColor(Color.GREEN)
        if (codedElement.valencies.find { it == 6 } == 6) valency_six_check_box.setBackgroundColor(Color.GREEN)
        if (codedElement.valencies.find { it == 7 } == 7) valency_seven_check_box.setBackgroundColor(Color.GREEN)
    }

    private fun showWrongAnswer() {
//        if(constant_valency_radio_button.isChecked) {
//            constant_valency_radio_button.setBackgroundColor(Color.RED)
//        }else{
//            constant_valency_radio_button.setBackgroundColor(Color.RED)
//        }
//        if (valency_one_check_box.isChecked) valency_one_check_box.setBackgroundColor(Color.RED)
//        if (valency_two_check_box.isChecked) valency_two_check_box.setBackgroundColor(Color.RED)
//        if (valency_three_check_box.isChecked) valency_three_check_box.setBackgroundColor(Color.RED)
//        if (valency_four_check_box.isChecked) valency_four_check_box.setBackgroundColor(Color.RED)
//        if (valency_five_check_box.isChecked) valency_five_check_box.setBackgroundColor(Color.RED)
//        if (valency_six_check_box.isChecked) valency_six_check_box.setBackgroundColor(Color.RED)
//        if (valency_seven_check_box.isChecked) valency_seven_check_box.setBackgroundColor(Color.RED)
    }

    private fun cleanAnswerField() {
        constant_valency_radio_button.isChecked = true
        constant_valency_radio_button.setBackgroundColor(Color.TRANSPARENT)
        variable_valency_radio_button.setBackgroundColor(Color.TRANSPARENT)
        valency_one_check_box.isChecked = false
        valency_one_check_box.setBackgroundColor(Color.TRANSPARENT)
        valency_two_check_box.isChecked = false
        valency_two_check_box.setBackgroundColor(Color.TRANSPARENT)
        valency_three_check_box.isChecked = false
        valency_three_check_box.setBackgroundColor(Color.TRANSPARENT)
        valency_four_check_box.isChecked = false
        valency_four_check_box.setBackgroundColor(Color.TRANSPARENT)
        valency_five_check_box.isChecked = false
        valency_five_check_box.setBackgroundColor(Color.TRANSPARENT)
        valency_six_check_box.isChecked = false
        valency_six_check_box.setBackgroundColor(Color.TRANSPARENT)
        valency_seven_check_box.isChecked = false
        valency_seven_check_box.setBackgroundColor(Color.TRANSPARENT)
    }

    fun formAnswer() {
        answer = Answer(codedElement, answerTypeOfValency(), answerValency())
    }

    fun setAskedElement() {
        SlideAnimationUtil.slideOutToRight(this, element_relative_layout,
                SlideAnimationUtil.SlideAnimationListener {

                    element_relative_layout.visibility = View.INVISIBLE

                    cleanAnswerField()
                    codedElement = randomElement()
                    element_text_view.text = codedElement.symbol

                    element_relative_layout.visibility = View.VISIBLE

                    SlideAnimationUtil.slideInFromLeft(this, element_relative_layout, null, SlideAnimationUtil.SLOWLY)
                }, SlideAnimationUtil.SLOWLY)

    }

    fun answerTypeOfValency() = constant_valency_radio_button.isChecked

    fun answerValency(): List<Int> {
        val listOfValency = mutableListOf<Int>()
        if (valency_one_check_box.isChecked) listOfValency.add(1)
        if (valency_two_check_box.isChecked) listOfValency.add(2)
        if (valency_three_check_box.isChecked) listOfValency.add(3)
        if (valency_four_check_box.isChecked) listOfValency.add(4)
        if (valency_five_check_box.isChecked) listOfValency.add(5)
        if (valency_six_check_box.isChecked) listOfValency.add(6)
        if (valency_seven_check_box.isChecked) listOfValency.add(7)
        return listOfValency
    }
}
