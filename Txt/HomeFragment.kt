package com.amango.permisdeconduire.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.amango.permisdeconduire.R

class HomeFragment : Fragment() {
    private var originalMode : Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        //ajust Input Mode Code
        activity?.window?.attributes?.softInputMode
        originalMode = activity?.window?.getSoftInputMode()
        activity?.window?.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
                )

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    //ajust Input Mode Code Suite
    override fun onDestroy() {
        super.onDestroy()
        originalMode?.let { activity?.window?.setSoftInputMode(it) }
    }
    //ajust Input Mode Code Suite
    fun Window.getSoftInputMode() : Int = attributes.softInputMode

}