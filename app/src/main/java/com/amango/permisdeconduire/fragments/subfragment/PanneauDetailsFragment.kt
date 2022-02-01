package com.amango.permisdeconduire.fragments.subfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.CoursesAdapter
import com.amango.permisdeconduire.adapter.PanneauDetailAdapter
import com.amango.permisdeconduire.data.PanneauData
import com.amango.permisdeconduire.data.PanneauDetailData
import com.amango.permisdeconduire.fragments.PanneauFragment
import kotlinx.android.synthetic.main.fragment_courses.view.*
import kotlinx.android.synthetic.main.fragment_panneau_details.view.*

class PanneauDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_panneau_details, container, false)

        //get data from panneau fragment
        val args = this.arguments
        val titreCategoriePanneau = args?.get("titre").toString()
        v.textView_titre_categorie_panneau.text  = args?.get("titre").toString()
        v.textView_desc_type_panneau.text = args?.get("desc").toString()

        //saisir les éléments qui seront dans la liste
        /**Récupération des données depuis la base de donnée**/
        var listItem : ArrayList<PanneauDetailData>
        listItem = arrayListOf(
            PanneauDetailData("Interdit","",R.drawable.img_interdit)
        )

        //la venue de l'adaptateur
        val adapter_list : PanneauDetailAdapter

        if (titreCategoriePanneau=="Les panneaux de danger"){
            //mise dans l'adptater
            adapter_list = PanneauDetailAdapter(v.context, R.layout.item_panneau,listItem)
            v.panneau_details_listView.adapter = adapter_list
        }
        return v
    }

}