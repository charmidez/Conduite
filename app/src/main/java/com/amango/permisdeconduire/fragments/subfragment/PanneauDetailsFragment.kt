package com.amango.permisdeconduire.fragments.subfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.MyAdapter
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauDanger
import kotlinx.android.synthetic.main.fragment_panneau_details.view.*

class PanneauDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_panneau_details, container, false)

        //get data from panneau fragment
        val args = this.arguments
        v.textView_titre_categorie_panneau.text  = args?.get("titre").toString()
        v.textView_desc_type_panneau.text = args?.get("desc").toString()

        //Part 2
        val adapter_list : MyAdapter

        //Part 3
        when(args?.get("titre").toString()){
            "Les panneaux de danger" -> {
                adapter_list = MyAdapter(v.context, R.layout.item_panneau,itemListPanneauDanger)
                v.panneau_details_listView.adapter = adapter_list
            }
        }
        return v
    }

}