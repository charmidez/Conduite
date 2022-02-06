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
import kotlinx.android.synthetic.main.fragment_apropos.*
import kotlinx.android.synthetic.main.fragment_apropos.view.*
import javax.security.auth.callback.Callback

class AproposFragment : Fragment() {

    private  val imgUrl = "https://cdn.pixabay.com/photo/2016/02/25/16/33/fruit-1222438_960_720.png"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_apropos, container, false)

         Glide.with(v.context)
            .load(imgUrl)
            .into(v.imageView_apropos_net)
        
        // Inflate the layout for this fragment
        return v
    }
}



