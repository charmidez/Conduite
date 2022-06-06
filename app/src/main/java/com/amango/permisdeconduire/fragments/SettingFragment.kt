package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.fragments.subfragment.AproposFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_setting.view.*

class SettingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater!!.inflate(R.layout.fragment_setting, container, false)

        MobileAds.initialize(v.context)
        val adRequest = AdRequest.Builder().build()
        v.adView_fragment_setting_bottom.loadAd(adRequest)
        v.adView_fragment_setting_top.loadAd(adRequest)

        v.textView_nous.setOnClickListener { view ->
            replaceFragment(aproposFragment)
        }
        v.textView4.setOnClickListener {
            replaceFragment(aproposFragment)
        }
        return v
    }

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