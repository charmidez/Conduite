package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.MyAdapter
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListCourses
import kotlinx.android.synthetic.main.fragment_courses.view.*

class CoursesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_courses, container, false)

        //Part 2
        val adapter_list : MyAdapter

        //Part 3
        adapter_list = MyAdapter(v.context, R.layout.item_courses, itemListCourses )
        v.listView_courses.adapter = adapter_list
        return v
    }
}