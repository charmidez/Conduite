package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amango.permisdeconduire.adapter.GeneralAdapter
import com.amango.permisdeconduire.data.DataCours
import com.amango.permisdeconduire.databinding.FragmentCoursesBinding
import com.google.android.gms.ads.MobileAds


class CoursesFragment : Fragment() {

    private var _binding : FragmentCoursesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCoursesBinding.inflate(inflater,container,false)
        val root : View = binding.root

        var recyclerViewCourse : RecyclerView
        var itemList : ArrayList<DataCours>

        itemList = arrayListOf()
        recyclerViewCourse = binding.recyclerViewCourse

        MobileAds.initialize(root.context)

        itemList.add(DataCours("Titre ","Cours",""))
        itemList.add(DataCours("Titre 2","Cours 2",""))
        itemList.add(DataCours("Titre 3","Cours 2",""))
        //il faut ajouter les données à itemList
        recyclerViewCourse.adapter = GeneralAdapter(binding.root.context, itemList, 1)
        return root
    }
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