package com.amango.permisdeconduire.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.data.Data
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_courses.view.*
import kotlinx.android.synthetic.main.item_panneau.view.*
import kotlinx.android.synthetic.main.item_panneau_type.view.*

class MyAdapter(
    var mContext : Context,
    var ressource : Int,
    var values : ArrayList<Data>
)  : ArrayAdapter<Data>(mContext,ressource,values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val data = values[position]
        val iView = LayoutInflater.from(mContext).inflate(ressource, parent, false)

        var title : TextView
        var img  : ImageView
        var desc : TextView

        var item_xml = ressource

        //getElement from itemView func
        when(item_xml){
            R.layout.item_panneau_type -> {
                img = iView.imageView_type_panneau
                title = iView.textView_titre_type_panneau
                desc = iView.textView_description_type_panneau
                //push data into in
                title.text = data.title
                Glide.with(mContext)
                    .load(Uri.parse(data.imgUrl))
                    .into(img)
                desc.text = data.desc
            }

            R.layout.item_courses -> {
                title = iView.textView_titre_course_item
                img = iView.imageView_courses_item
                title.text = data.title
                Glide.with(mContext)
                    .load(Uri.parse(data.imgUrl))
                    .into(img)
                //desc.text = data.description
            }

            R.layout.item_panneau ->{
                title = iView.textView_panneau
                img = iView.imageView_panneau
                title.text = data.title
                Glide.with(mContext)
                    .load(Uri.parse(data.imgUrl))
                    .into(img)
            }
        }
        return iView
    }

}