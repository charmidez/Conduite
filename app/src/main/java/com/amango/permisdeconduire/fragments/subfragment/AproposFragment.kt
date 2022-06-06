package com.amango.permisdeconduire.fragments.subfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.fragments.SettingFragment
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_apropos.*
import kotlinx.android.synthetic.main.fragment_apropos.view.*
import javax.security.auth.callback.Callback

class AproposFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_apropos, container, false)

        MobileAds.initialize(v.context)
        val adRequest = AdRequest.Builder().build()
        v.adView_fragment_apropos_bottom.loadAd(adRequest)
        v.adView_fragment_apropos_top.loadAd(adRequest)

        return v
    }
}



