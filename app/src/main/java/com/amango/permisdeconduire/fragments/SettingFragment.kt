package com.amango.permisdeconduire.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.fragments.subfragment.AproposFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_setting.view.*

class SettingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_setting, container, false)

        view.textView_nous.setOnClickListener { view ->
            //Log.d("btnSetup", "Selected")
            replaceFragment(aproposFragment)
        }
        view.textView4.setOnClickListener {
            replaceFragment(aproposFragment)
        }
        // Return the fragment view/layout
        return view
    }

    // Change Fragment
    private val aproposFragment = AproposFragment()

    private fun replaceFragment(fragment : Fragment){
        if (fragment !=null){
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }


}