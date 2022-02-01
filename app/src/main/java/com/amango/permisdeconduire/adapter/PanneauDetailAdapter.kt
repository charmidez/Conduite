package com.amango.permisdeconduire.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.amango.permisdeconduire.data.PanneauDetailData
import kotlinx.android.synthetic.main.item_panneau.view.*

class PanneauDetailAdapter(var mContext : Context,
                           var ressource : Int,
                           var values : ArrayList<PanneauDetailData>) :  ArrayAdapter<PanneauDetailData>(mContext, ressource, values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //les positions tout court
        val panneauDetails = values[position]

        val itemView = LayoutInflater.from(mContext).inflate(ressource, parent, false)

        //les itemView de Panneau detaill
        val nom_panneau_details = itemView.textView_panneau
        val img_panneau_details = itemView.imageView_panneau


        //assignation dans panneau
        nom_panneau_details.text = panneauDetails.titrePanneau
        img_panneau_details.setImageResource(panneauDetails.imgPanneau)

        return itemView
    }
}