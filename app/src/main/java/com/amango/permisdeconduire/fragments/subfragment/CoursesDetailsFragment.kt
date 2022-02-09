package com.amango.permisdeconduire.fragments.subfragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_courses_details.view.*

class CoursesDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_courses_details, container, false)

        val args = this.arguments
        v.textView_titre_courses_detail.text = args?.get("titre").toString()
        v.textView_desc_courses_detail.text = args?.get("desc").toString()
        Glide.with(v.context)
            .load(Uri.parse(args?.get("imgUrl").toString()))
            .into(v.imgView_detail_course)

        return v
    }
}