package com.amango.permisdeconduire.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.amango.permisdeconduire.data.PanneauData
import kotlinx.android.synthetic.main.item_panneau_type.view.*
import kotlinx.android.synthetic.main.item_panneau.view.*

class PanneauAdapter(
                    var mContext : Context,
                     var ressource : Int,
                     var values : ArrayList<PanneauData>) : ArrayAdapter<PanneauData>(mContext, ressource, values){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //les positions tout court
        val panneauType = values[position]
        val itemView = LayoutInflater.from(mContext).inflate(ressource, parent, false)

        //les itemView de panneau Type
        val titre_panneau = itemView.textView_titre_type_panneau
        val desc_panneau = itemView.textView_description_type_panneau
        val img_panneau = itemView.imageView_type_panneau

        //assignation dans Panneau_type_view ok
        titre_panneau.text = panneauType.titreTypePanneau
        desc_panneau.text = panneauType.descriptionTypePanneau
        img_panneau.setImageResource(panneauType.imgTypePanneau)

        return itemView
    }


}