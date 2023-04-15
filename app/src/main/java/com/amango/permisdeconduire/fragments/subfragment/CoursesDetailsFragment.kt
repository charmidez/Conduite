package com.amango.permisdeconduire.fragments.subfragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.databinding.FragmentCoursesDetailsBinding
import com.bumptech.glide.Glide


class CoursesDetailsFragment : Fragment() {

    private var _binding : FragmentCoursesDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCoursesDetailsBinding.inflate(inflater,container,false)
        val root : View = binding.root
        //val v = inflater.inflate(R.layout.fragment_courses_details, container, false)

        val args = this.arguments
        //v.textView_titre_courses_detail.text = args?.get("titre").toString()
        //v.textView_desc_courses_detail.text = args?.get("desc").toString()
        binding.textViewTitreCoursesDetail.text = args?.get("titre").toString()
        binding.textViewDescCoursesDetail.text = args?.get("desc").toString()

        Glide.with(root.context)
            .load(Uri.parse(args?.get("imgUrl").toString()))
            .into(binding.imgViewDetailCourse)

        return root
    }
}