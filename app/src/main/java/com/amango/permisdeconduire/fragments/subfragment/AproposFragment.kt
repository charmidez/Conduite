package com.amango.permisdeconduire.fragments.subfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.fragments.SettingFragment
import javax.security.auth.callback.Callback

class AproposFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apropos, container, false)
    }
}



