package com.amango.permisdeconduire.fragments

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.data.Data
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemExam
import com.bumptech.glide.Glide
import com.google.android.play.core.appupdate.v
import com.google.firebase.database.collection.LLRBNode
import kotlinx.android.synthetic.main.fragment_examen.*
import kotlinx.android.synthetic.main.fragment_examen.view.*

class ExamenFragment : Fragment(), View.OnClickListener {

    private var itemQuizz : ArrayList<Data>?  = null
    private var mCurrentPosition :Int = 1

    private var setQuizz = fun(){}
    private var defaultOptionView = fun(){}
    private var selectedOptionView = fun(){}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_examen, container, false)
        itemQuizz = itemExam

        //function
        defaultOptionView = fun(){
            val options = ArrayList<TextView>()
            options.add(0,textView_optionOne)
            options.add(1,textView_optionTwo)
            options.add(2,textView_optionThree)
            options.add(3,textView_optionFour)

            for (option in options){
                //option.setCardBackgroundColor(Color.parseColor("FF08894E"))
                //option.typeface = Typeface.DEFAULT_BOLD
            }
        }

        setQuizz = fun(){
            mCurrentPosition = 1

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

        //1
        v.textView_optionOne.setOnClickListener(this)
        v.cardView_optionOne.setOnClickListener(this)
        //2
        v.textView_optionTwo.setOnClickListener(this)
        v.cardView_optionTwo.setOnClickListener(this)
        //3
        v.textView_optionThree.setOnClickListener(this)
        v.cardView_optionThree.setOnClickListener(this)
        //4
        v.textView_optionFour.setOnClickListener(this)
        v.cardView_optionFour

        return v
    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.textView_optionOne -> {
                selectedOptionView(cardView_optionOne, textView_optionOne,1)
            }
            R.id.textView_optionTwo -> {
                selectedOptionView(cardView_optionTwo, textView_optionTwo,2)
            }
            R.id.textView_optionThree -> {
                selectedOptionView(cardView_optionThree, textView_optionThree,3)
            }
            R.id.textView_optionFour -> {
                selectedOptionView(cardView_optionFour, textView_optionFour,4)
            }
            R.id.button_subimt -> {

            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {

            }
            2 -> {

            }
            3 -> {

            }
            4 -> {

            }
        }
    }

    private fun selectedOptionView (cv : CardView, tv : TextView, selectedOptionNum : Int){
        defaultOptionView()
        mCurrentPosition = selectedOptionNum
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#08894E"))

        cv.setCardBackgroundColor(Color.parseColor("#08894E"))
    }

}

