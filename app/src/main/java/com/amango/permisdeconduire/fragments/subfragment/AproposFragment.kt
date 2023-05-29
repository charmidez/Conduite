package com.amango.permisdeconduire.fragments.subfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.databinding.FragmentAproposBinding

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds


class AproposFragment : Fragment() {

    private var _binding : FragmentAproposBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAproposBinding.inflate(inflater,container,false)
        val root : View = binding.root


        return root
    }
}



