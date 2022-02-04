package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.CoursesAdapter
import com.amango.permisdeconduire.data.CoursesData
import kotlinx.android.synthetic.main.fragment_courses.view.*

class CoursesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_courses, container, false)

        //les elements du cours android:dividerHeight="@dimen/padding_size_in_activity"
        var list_item : ArrayList<CoursesData>
        list_item = arrayListOf(
            CoursesData("Le cours","La description du cours", R.drawable.img_danger),
            CoursesData("Le cours","La description du cours", R.drawable.img_danger),
            CoursesData("Le cours","La description du cours", R.drawable.img_danger),
            CoursesData("Le cours","La description du cours", R.drawable.img_danger),
            CoursesData("Le cours","La description du cours", R.drawable.img_danger),
            CoursesData("Le cours","La description du cours", R.drawable.img_danger),
            CoursesData("Le cours","La description du cours", R.drawable.img_danger)
        )

        //la venue de l'adaptateur
        val adapter_list : CoursesAdapter

        //mise dans l'adptater
        adapter_list = CoursesAdapter(v.context, R.layout.item_courses,list_item)

        v.listView_courses.adapter = adapter_list
        return v
    }
}