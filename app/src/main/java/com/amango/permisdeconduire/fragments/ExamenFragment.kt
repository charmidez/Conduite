package com.amango.permisdeconduire.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.data.Data
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemExam
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_examen.*
import kotlinx.android.synthetic.main.fragment_examen.view.*

class ExamenFragment : Fragment(), View.OnClickListener {

    private var itemQuizz : ArrayList<Data>?  = null
    private var mCurrentPosition :Int = 1
    private var mSelectedOption = 0

    private var setQuizz = fun(){}
    private var defaultOptionView = fun(){}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_examen, container, false)
        itemQuizz = itemExam

        //function
        defaultOptionView = fun(){
            val cardView_options = ArrayList<CardView>()
            val textView_options = ArrayList<TextView>()
            cardView_options.add(0,v.cardView_optionOne)
            textView_options.add(0,v.textView_optionOne)
            cardView_options.add(1,v.cardView_optionTwo)
            textView_options.add(1,v.textView_optionTwo)
            cardView_options.add(2,v.cardView_optionThree)
            textView_options.add(2,v.textView_optionThree)
            cardView_options.add(3,v.cardView_optionFour)
            textView_options.add(3,v.textView_optionFour)
            v.button_submit.setTextColor(Color.parseColor("#166D8A"))
            v.button_submit.text = "Choisissez La bonne réponse"
            v.button_submit.setBackgroundColor(Color.parseColor("#00FFFFFF"))

            for (option in cardView_options){
                option.setCardBackgroundColor(Color.parseColor("#F4F3EE"))
                option.setElevation(8F)
            }
            for (option in textView_options){
                option.setTextColor(Color.parseColor("#166D8A"))
            }

        }

        //function
        setQuizz = fun(){
            mSelectedOption = 0
            defaultOptionView()

            val questionQuizz = itemQuizz!![mCurrentPosition - 1].title
            val imgQuizzUrl = itemQuizz!![mCurrentPosition -1].imgUrl
            val optionOne = itemQuizz!![mCurrentPosition - 1].optionOne
            val optionTwo = itemQuizz!![mCurrentPosition - 1].optionTwo
            val optionThree = itemQuizz!![mCurrentPosition - 1].optionThree
            val optionFour = itemQuizz!![mCurrentPosition - 1].optionFour

            v.progressBar_level_quizz.progress = mCurrentPosition
            v.textView_progressBar.text = "$mCurrentPosition" + "/" + v.progressBar_level_quizz.max
            v.textView_question.text = questionQuizz
            Glide.with(v.context)
                .load(imgQuizzUrl)
                .centerCrop()
                .into(v.imageView_question)
            v.textView_optionOne.text = optionOne
            v.textView_optionTwo.text = optionTwo
            v.textView_optionThree.text = optionThree
            v.textView_optionFour.text = optionFour
        }
        setQuizz()
        v.cardView_optionOne.setOnClickListener(this)
        v.cardView_optionTwo.setOnClickListener(this)
        v.cardView_optionThree.setOnClickListener(this)
        v.cardView_optionFour.setOnClickListener(this)
        v.button_submit.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cardView_optionOne -> {
                selectedOptionView(cardView_optionOne, textView_optionOne,1)
            }
            R.id.cardView_optionTwo -> {
                selectedOptionView(cardView_optionTwo, textView_optionTwo,2)
            }
            R.id.cardView_optionThree -> {
                selectedOptionView(cardView_optionThree, textView_optionThree,3)
            }
            R.id.cardView_optionFour -> {
                selectedOptionView(cardView_optionFour, textView_optionFour,4)
            }
            R.id.button_submit -> {
                if (mSelectedOption != 0){
                    if(mSelectedOption==itemQuizz!![mCurrentPosition].rep){
                    } else if (mSelectedOption!=itemQuizz!![mCurrentPosition].rep) {
                        wrongAnswerView(mSelectedOption)
                    }
                    val correct = itemQuizz!![mCurrentPosition].rep.toString().toInt()
                    answerView(correct)
                    nextQuestion()
                    mSelectedOption = 0
                }else {
                    mCurrentPosition ++
                    setQuizz()
                }
            }
        }
    }

    private fun answerView(answer : Int){
        when(answer){
            1 -> {
                answerOptionView(cardView_optionOne, textView_optionOne)
            }
            2 -> {
                answerOptionView(cardView_optionTwo, textView_optionTwo)
            }
            3 -> {
                answerOptionView(cardView_optionThree, textView_optionThree)
            }
            4 -> {
                answerOptionView(cardView_optionFour, textView_optionFour)
            }
        }
    }

    private fun wrongAnswerView(wronganswer : Int){
        when(wronganswer){
            1 -> wrongAnswerOptionView(cardView_optionOne, textView_optionOne)
            2 -> wrongAnswerOptionView(cardView_optionTwo, textView_optionTwo)
            3 -> wrongAnswerOptionView(cardView_optionThree, textView_optionThree)
            4 -> wrongAnswerOptionView(cardView_optionFour, textView_optionFour)
        }
    }

    private fun selectedOptionView (cv : CardView, tv : TextView, selectedOptionNum : Int){
        defaultOptionView()
        mSelectedOption = selectedOptionNum
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#F4F3EE"))

        cv.setCardBackgroundColor(Color.parseColor("#31F4F3EE"))
        cv.setElevation(1F)

        button_submit.setBackgroundResource(R.drawable.rounded_buttonview)
        button_submit.text = "Soumettre La Proposition"
        button_submit.setTextColor(Color.parseColor("#F4F3EE"))

        //Log.i("mSelectOption", mSelectedOptionPosition.toString())
    }

    private fun answerOptionView (cv : CardView, tv : TextView){
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#F4F3EE"))
        cv.setCardBackgroundColor(Color.parseColor("#5FAD41"))
        cv.setElevation(8F)
    }

    private fun wrongAnswerOptionView (cv : CardView, tv : TextView){
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#F4F3EE"))
        cv.setCardBackgroundColor(Color.parseColor("#EE6352"))
        cv.setElevation(8F)
    }

    private fun nextQuestion(){
        button_submit.setBackgroundResource(R.drawable.rounded_buttonview_nextquestion)
        button_submit.text = "Question Suivante"
        button_submit.setTextColor(Color.parseColor("#F4F3EE"))
    }
}

