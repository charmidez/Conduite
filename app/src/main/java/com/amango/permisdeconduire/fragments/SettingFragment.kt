package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.databinding.FragmentSettingBinding
import com.amango.permisdeconduire.fragments.subfragment.AproposFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class SettingFragment : Fragment() {

    private var _binding : FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSettingBinding.inflate(inflater,container,false)
        val root : View = binding.root

        MobileAds.initialize(context)
        val adRequest = AdRequest.Builder().build()
        binding.adViewFragmentSettingBottom.loadAd(adRequest)
        binding.adViewFragmentSettingTop.loadAd(adRequest)

        binding.textViewNous.setOnClickListener{
            replaceFragment(aproposFragment)
        }
        binding.textView4.setOnClickListener {
            replaceFragment(aproposFragment)
        }
        return root
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