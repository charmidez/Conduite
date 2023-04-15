package com.amango.permisdeconduire.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.data.DataCours
import com.bumptech.glide.Glide

class CoursAdapter(var mContext : Context, var items : ArrayList<DataCours>) : RecyclerView.Adapter<CoursAdapter.CoursViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_courses, parent, false)

        return CoursViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CoursViewHolder, position: Int) {
        val itemPosition = items[position]
        //holder
        holder.txtViewTitreCourse.text = itemPosition.title
        Glide.with(mContext).load(Uri.parse(itemPosition.imgUrl)).into(holder.imgViewCourse)

    }

    class CoursViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgViewCourse : ImageView
        var txtViewTitreCourse : TextView
        init {
            imgViewCourse = itemView.findViewById<ImageView>(R.id.imageView_courses_item)
            txtViewTitreCourse = itemView.findViewById<TextView>(R.id.textView_titre_course_item)
        }

    }

}