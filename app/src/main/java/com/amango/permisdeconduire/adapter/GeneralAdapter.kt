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

class GeneralAdapter(var mContext : Context, var items : ArrayList<DataCours>, var nBr : Int,) : RecyclerView.Adapter<GeneralAdapter.GeneralViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {

        //var itemView_cours = LayoutInflater.from(parent.context).inflate(R.layout.item_courses, parent, false)
        //var itemView_panneau = LayoutInflater.from(parent.context).inflate(R.layout.item_panneau_type, parent, false)
        //var itemView_panneau_details = LayoutInflater.from(parent.context).inflate(R.layout.item_panneau, parent, false)
        //var itemView_grid = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)

        var itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_panneau_type,parent,false)

        when(nBr){
            1 -> {itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_courses, parent, false)}
            2 -> {itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_panneau_type, parent, false)}
            3 -> {itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_panneau, parent, false)}
            4 -> {itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)}
        }

        return GeneralViewHolder(itemView)
    }

    class GeneralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imgViewCourse : ImageView
        var txtViewTitreCourse : TextView
        var txtViewDescription : TextView
        init {
            imgViewCourse = itemView.findViewById(R.id.imageView_item)
            txtViewTitreCourse = itemView.findViewById(R.id.textView_titre_item)
            txtViewDescription = itemView.findViewById(R.id.textView_description_item)
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        val itemPosition = items[position]
        when(nBr){
            1 -> {
                holder.txtViewTitreCourse.text = itemPosition.title
                Glide.with(mContext).load(Uri.parse(itemPosition.imgUrl)).into(holder.imgViewCourse)
            }
            2 -> {
                holder.txtViewTitreCourse.text = itemPosition.title
                Glide.with(mContext).load(Uri.parse(itemPosition.imgUrl)).into(holder.imgViewCourse)
                holder.txtViewDescription.text = itemPosition.desc
            }
            3 -> {}
            4 -> {}
        }

        //holder.txtViewDescription.text = itemPosition.desc


    }
}