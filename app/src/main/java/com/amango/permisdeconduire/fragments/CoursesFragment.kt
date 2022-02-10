package com.amango.permisdeconduire.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.MyAdapter
import com.amango.permisdeconduire.db.DataRepository
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemExam
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListCourses
import com.amango.permisdeconduire.fragments.subfragment.CoursesDetailsFragment
import kotlinx.android.synthetic.main.fragment_courses.view.*

class CoursesFragment : Fragment() {

    private val coursesDetailsFragment = CoursesDetailsFragment()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_courses, container, false)

        //Part 2
        val adapter_list : MyAdapter

        //Part 3
        adapter_list = MyAdapter(v.context, R.layout.item_courses, itemListCourses )
        v.listView_courses.adapter = adapter_list

        v.listView_courses.setOnItemClickListener{adpterView, view, position, id ->
            val bundles = Bundle()
            val clickedPost = itemListCourses [position]
            bundles.putString("titre", clickedPost.title)
            bundles.putString("desc",clickedPost.desc)
            bundles.putString("imgUrl",clickedPost.imgUrl)
            coursesDetailsFragment.arguments = bundles
            replaceFragment(coursesDetailsFragment)
        }
        return v
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