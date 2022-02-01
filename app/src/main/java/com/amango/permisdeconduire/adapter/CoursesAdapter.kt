package com.amango.permisdeconduire.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.amango.permisdeconduire.data.CoursesData
import kotlinx.android.synthetic.main.item_courses.view.*
import kotlinx.android.synthetic.main.item_panneau_type.view.*

class CoursesAdapter(var mContext : Context,
                     var ressource : Int,
                     var values : ArrayList<CoursesData>) : ArrayAdapter<CoursesData>(mContext, ressource, values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val courses = values[position]

        val itemView = LayoutInflater.from(mContext).inflate(ressource, parent, false)

        //getElement de l'itemView
        val titre_cours = itemView.textView_titre_course_item
        val img = itemView.imageView_courses_item

        titre_cours.text = courses.titreCours
        img.setImageResource(courses.imgCours)

        return itemView
    }

}