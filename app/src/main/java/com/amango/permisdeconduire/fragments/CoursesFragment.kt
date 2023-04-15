package com.amango.permisdeconduire.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amango.permisdeconduire.adapter.CoursAdapter
import com.amango.permisdeconduire.data.DataCours
import com.amango.permisdeconduire.databinding.FragmentCoursesBinding
import com.amango.permisdeconduire.fragments.subfragment.CoursesDetailsFragment
import com.google.android.gms.ads.MobileAds


class CoursesFragment : Fragment() {

    private var _binding : FragmentCoursesBinding? = null
    private val binding get() = _binding!!

    private val coursesDetailsFragment = CoursesDetailsFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCoursesBinding.inflate(inflater,container,false)
        val root : View = binding.root
        //val v = inflater.inflate(R.layout.fragment_courses, container, false)
        var recyclerViewCourse : RecyclerView
        var itemList : ArrayList<DataCours>
        itemList = arrayListOf()
        recyclerViewCourse = binding.recyclerViewCourse

        MobileAds.initialize(root.context)
        //val adRequest = AdRequest.Builder().build()
        //v.adView.loadAd(adRequest)

        //Part 2 test


        //Part 3
        //recyclerView_TC.adapter = TCAdapter(items_tc, this@SuivietcFragment)
        itemList.add(DataCours("Titre","Cours",""))
        itemList.add(DataCours("Titre 2","Cours 2",""))
        recyclerViewCourse.adapter = CoursAdapter(requireContext(), itemList).apply {
            Log.d("Herve",itemList.size.toString())
        }

        //adapter_list = MyAdapter(root.context, R.layout.item_courses, itemListCourses )
        //v.listView_courses.adapter = adapter_list
        //binding.listViewCourses.adapter = adapter_list


        /*
        binding.listViewCourses.setOnItemClickListener { adpterView, view, position, id ->
            val bundles = Bundle()
            val clickedPost = itemListCourses [position]
            bundles.putString("titre", clickedPost.title)
            bundles.putString("desc",clickedPost.desc)
            bundles.putString("imgUrl",clickedPost.imgUrl)
            coursesDetailsFragment.arguments = bundles
            replaceFragment(coursesDetailsFragment)
        }

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

    /*
    private fun replaceFragment(fragment : Fragment){
        if (fragment !=null){
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }
    */
}