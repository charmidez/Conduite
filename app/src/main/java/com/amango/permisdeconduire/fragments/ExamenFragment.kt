package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_examen.*
import kotlinx.android.synthetic.main.fragment_examen.view.*

class ExamenFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_examen, container, false)

        Glide.with(v.context)
            .load("https://images.prismic.io/ornikar/3f92c9d1dd6774ab5eeb85ce599b9d55b6e7d7fd_panneau-danger-virages-epingle.jpg?auto=compress,format")
            .centerCrop()
            .into(v.imageView_question)



        return v
    }
}