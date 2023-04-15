package com.amango.permisdeconduire.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.MyAdapter
import com.amango.permisdeconduire.databinding.FragmentCoursesBinding
import com.amango.permisdeconduire.db.DataRepository
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemExam
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListCourses
import com.amango.permisdeconduire.fragments.subfragment.CoursesDetailsFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds


class CoursesFragment : Fragment() {

    private var _binding : FragmentCoursesBinding? = null
    private val binding get() = _binding!!

    private val coursesDetailsFragment = CoursesDetailsFragment()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCoursesBinding.inflate(inflater,container,false)
        val root : View = binding.root
        //val v = inflater.inflate(R.layout.fragment_courses, container, false)

        MobileAds.initialize(root.context)
        //val adRequest = AdRequest.Builder().build()
        //v.adView.loadAd(adRequest)

        //Part 2 test
        val adapter_list : MyAdapter

        //Part 3
        adapter_list = MyAdapter(root.context, R.layout.item_courses, itemListCourses )
        //v.listView_courses.adapter = adapter_list
        binding.listViewCourses.adapter = adapter_list

        binding.listViewCourses.setOnItemClickListener { adpterView, view, position, id ->
            val bundles = Bundle()
            val clickedPost = itemListCourses [position]
            bundles.putString("titre", clickedPost.title)
            bundles.putString("desc",clickedPost.desc)
            bundles.putString("imgUrl",clickedPost.imgUrl)
            coursesDetailsFragment.arguments = bundles
            replaceFragment(coursesDetailsFragment)
        }
        /*
        v.listView_courses.setOnItemClickListener{adpterView, view, position, id ->
            val bundles = Bundle()
            val clickedPost = itemListCourses [position]
            bundles.putString("titre", clickedPost.title)
            bundles.putString("desc",clickedPost.desc)
            bundles.putString("imgUrl",clickedPost.imgUrl)
            coursesDetailsFragment.arguments = bundles
            replaceFragment(coursesDetailsFragment)
        }
        */
        return root
    }

    private fun replaceFragment(fragment : Fragment){
        if (fragment !=null){
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }
}