package com.amango.permisdeconduire.fragments.subfragment

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.data.Data
import com.amango.permisdeconduire.databinding.FragmentExamenQuizzBinding
import com.amango.permisdeconduire.databinding.PopupCongratulationBinding
import com.amango.permisdeconduire.db.DataRepository
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class ExamenQuizzFragment : Fragment() , View.OnClickListener {

    private var _binding : FragmentExamenQuizzBinding? = null
    private val binding get() = _binding!!

    private var itemQuizz : ArrayList<Data>?  = null
    private var mCurrentPosition :Int = 1
    private var mLevelProgresseBar : Int = 1
    private var mSelectedOption = 0
    private var scoreNote = 0
    private var setQuizz = fun(){}
    private var defaultOptionView = fun(){}
    private var initailize = fun(){
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentExamenQuizzBinding.inflate(inflater,container,false)
        val root : View = binding.root

         var cardViewOne = binding.cardViewOptionOne
        var cardViewTwo = binding.cardViewOptionTwo
        var cardViewThree = binding.cardViewOptionThree
        var cardViewFour = binding.cardViewOptionFour

        var txtViewOne = binding.textViewOptionOne
        var txtViewTwo = binding.textViewOptionTwo
        var txtViewThree = binding.textViewOptionThree
        var txtViewFour = binding.textViewOptionFour

        var btnSubmit = binding.buttonSubmit

        var progressBar_levelQuizz = binding.progressBarLevelQuizz
        var txtView_progress_bar = binding.textViewProgressBar

        var txtView_question = binding.textViewQuestion
        var imgView_question = binding.imageViewQuestion



        //var v = inflater.inflate(R.layout.fragment_examen_quizz, container, false)

        val args = this.arguments
        var idLevel = args?.getInt("niveau")

        val repo = DataRepository()

        MobileAds.initialize(root.context)
        val adRequest = AdRequest.Builder().build()
        //v.adView_fragment_examen_quizz_bottom.loadAd(adRequest)
        //binding.adViewFragmentExamenQuizzBottom.loadAd(adRequest)

        itemQuizz = DataRepository.Singleton.itemExam

        repo.updateDataQuizzQuestion {
        //function
        defaultOptionView = fun(){
            val cardView_options = ArrayList<LinearLayout>()
            val textView_options = ArrayList<TextView>()
            cardView_options.add(0,cardViewOne)
            textView_options.add(0,txtViewOne)
            cardView_options.add(1,cardViewTwo)
            textView_options.add(1,txtViewTwo)
            cardView_options.add(2,cardViewThree)
            textView_options.add(2,txtViewThree)
            cardView_options.add(3,cardViewFour)
            textView_options.add(3,txtViewFour)
            //v.button_submit.isEnabled = false
            btnSubmit.isEnabled  = false
            //v.button_submit.setTextColor(Color.parseColor("#166D8A"))
            btnSubmit.setTextColor(Color.parseColor("#166D8A"))
            //v.button_submit.text = getString(R.string.choose_right_answer)
            btnSubmit.text = getString(R.string.choose_right_answer)
            //v.button_submit.setBackgroundColor(Color.parseColor("#00FFFFFF"))
            btnSubmit.setBackgroundColor(Color.parseColor("#00FFFFFF"))

            for (option in cardView_options){
                option.setBackgroundColor(Color.parseColor("#F4F3EE"))
                option.setElevation(8F)
            }
            for (option in textView_options){
                option.setTextColor(Color.parseColor("#166D8A"))
            }
        }

        setQuizz = fun(){
            mSelectedOption = 0
            defaultOptionView()

            val questionQuizz = itemQuizz!![mCurrentPosition - 1].title
            val imgQuizzUrl = itemQuizz!![mCurrentPosition -1].imgUrl
            val optionOne = itemQuizz!![mCurrentPosition - 1].optionOne
            val optionTwo = itemQuizz!![mCurrentPosition - 1].optionTwo
            val optionThree = itemQuizz!![mCurrentPosition - 1].optionThree
            val optionFour = itemQuizz!![mCurrentPosition - 1].optionFour

            //v.progressBar_level_quizz.progress = mLevelProgresseBar
            progressBar_levelQuizz.progress = mLevelProgresseBar
            //v.textView_progressBar.text = "$mLevelProgresseBar" + "/" + v.progressBar_level_quizz.max
            txtView_progress_bar.text = "$mLevelProgresseBar" + "/" +progressBar_levelQuizz.max
            //v.textView_question.text = questionQuizz
            txtView_question.text = questionQuizz
            Glide.with(root.context)
                .load(imgQuizzUrl)
                .centerCrop()
                .into(imgView_question)
            txtViewOne.text = optionOne
            txtViewTwo.text = optionTwo
            txtViewThree.text = optionThree
            txtViewFour.text = optionFour
        }
        setQuizz()

            if (idLevel != null) {
                mCurrentPosition = idLevel
            }

            cardViewOne.setOnClickListener(this)
            cardViewTwo.setOnClickListener(this)
            cardViewThree.setOnClickListener(this)
            cardViewFour.setOnClickListener(this)
            btnSubmit.setOnClickListener(this)

        initailize = fun (){
            mCurrentPosition  = 1
            mSelectedOption = 0
            setQuizz()
        }
        }
        return root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cardView_optionOne -> {
                selectedOptionView(binding.cardViewOptionOne, binding.textViewOptionOne,1)
            }
            R.id.cardView_optionTwo -> {
                selectedOptionView(binding.cardViewOptionTwo, binding.textViewOptionTwo,2)
            }
            R.id.cardView_optionThree -> {
                selectedOptionView(binding.cardViewOptionThree, binding.textViewOptionThree,3)
            }
            R.id.cardView_optionFour -> {
                selectedOptionView(binding.cardViewOptionFour, binding.textViewOptionFour,4)
            }
            R.id.button_submit -> {
                if (mSelectedOption != 0){
                    if(mSelectedOption==itemQuizz!![mCurrentPosition].rep){
                        scoreNote++
                    } else if (mSelectedOption!=itemQuizz!![mCurrentPosition].rep) {
                        wrongAnswerView(mSelectedOption)
                    }
                    val correct = itemQuizz!![mCurrentPosition].rep.toString().toInt()
                    answerView(correct)
                    nextQuestion()
                    mSelectedOption = 0
                }else {
                    if (mCurrentPosition <= 19){
                        mCurrentPosition ++
                        mLevelProgresseBar++
                        setQuizz()
                    } else {
                        //popUpActivation()
                    }

                }
            }
        }
    }

    private fun answerView(answer : Int){
        when(answer){
            1 -> {
                answerOptionView(binding.cardViewOptionOne, binding.textViewOptionOne)
            }
            2 -> {
                answerOptionView(binding.cardViewOptionTwo, binding.textViewOptionTwo)
            }
            3 -> {
                answerOptionView(binding.cardViewOptionThree, binding.textViewOptionThree)
            }
            4 -> {
                answerOptionView(binding.cardViewOptionFour, binding.textViewOptionFour)
            }
        }
    }

    private fun wrongAnswerView(wronganswer : Int){
        when(wronganswer){
            1 -> wrongAnswerOptionView(binding.cardViewOptionOne, binding.textViewOptionOne)
            2 -> wrongAnswerOptionView(binding.cardViewOptionTwo, binding.textViewOptionTwo)
            3 -> wrongAnswerOptionView(binding.cardViewOptionThree, binding.textViewOptionThree)
            4 -> wrongAnswerOptionView(binding.cardViewOptionFour, binding.textViewOptionFour)
        }
    }

    private fun selectedOptionView (cv : LinearLayout, tv : TextView, selectedOptionNum : Int){
        defaultOptionView()
        mSelectedOption = selectedOptionNum
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#F4F3EE"))

        //cv.setCardBackgroundColor(Color.parseColor("#31F4F3EE"))
        cv.setBackgroundColor(Color.parseColor("#31F4F3EE"))
        cv.setElevation(1F)

        binding.buttonSubmit.isEnabled = true

        binding.buttonSubmit.setBackgroundResource(R.drawable.rounded_buttonview)
        binding.buttonSubmit.text = "Soumettre La Proposition"
        binding.buttonSubmit.setTextColor(Color.parseColor("#F4F3EE"))
    }

    private fun answerOptionView (cv : LinearLayout, tv : TextView){
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#F4F3EE"))
        cv.setBackgroundColor(Color.parseColor("#5FAD41"))
        cv.setElevation(8F)
    }

    private fun wrongAnswerOptionView (cv : LinearLayout, tv : TextView){
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#F4F3EE"))
        cv.setBackgroundColor(Color.parseColor("#EE6352"))
        cv.setElevation(8F)
    }

    private fun nextQuestion(){
        binding.buttonSubmit.setBackgroundResource(R.drawable.rounded_buttonview_nextquestion)
        binding.buttonSubmit.text = "Question Suivante"
        binding.buttonSubmit.setTextColor(Color.parseColor("#F4F3EE"))
    }

    /*
    private fun popUpActivation(){
        //val v = View.inflate(context,R.layout.popup_congratulation, null)
        var _binding : PopupCongratulationBinding? = null

        val  builder = AlertDialog.Builder(context)
        builder.setView(_binding!!.root)
        var score_obtenu_to_string = "$scoreNote /${progressBar_levelQuizz.max}"
        binding.scoreObtenu.text = score_obtenu_to_string
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        initailize()
    }
    */


}