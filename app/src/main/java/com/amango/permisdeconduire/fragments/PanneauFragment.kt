package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.PanneauAdapter
import com.amango.permisdeconduire.data.PanneauData
import com.amango.permisdeconduire.fragments.subfragment.AproposFragment
import com.amango.permisdeconduire.fragments.subfragment.PanneauDetailsFragment
import kotlinx.android.synthetic.main.fragment_panneau.view.*

class PanneauFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v : View = inflater.inflate(R.layout.fragment_panneau, container, false)

        //saisir les éléments qui seront dans la liste
        var listItem : ArrayList<PanneauData>
        listItem = arrayListOf(
            PanneauData(titrePanneau1 ,descPanneau1,img_1),
            PanneauData(titrePanneau2 ,descPanneau2,img_2),
            PanneauData(titrePanneau3 ,descPanneau3,img_3),
            PanneauData(titrePanneau4 ,descPanneau4,img_4),
            PanneauData(titrePanneau5 ,descPanneau5,img_5)
        )

        //ramener l'adpatateur
        var adapterlist : PanneauAdapter

        //mettre les éléments dans l'adptateur
        adapterlist = PanneauAdapter(  v.context, R.layout.item_panneau_type,listItem)

        //mettre le tout dans la listView
        v.listView_panneau.adapter = adapterlist

        v.listView_panneau.setOnItemClickListener {adpterView, view, position, id ->
            val bundles = Bundle()
            val clickedPost =  listItem [position]
            bundles.putString("titre", clickedPost.titreTypePanneau)
            bundles.putString("desc",clickedPost.descriptionTypePanneau)
            detailspanneauFragment.arguments = bundles
            replaceFragment(detailspanneauFragment)
        }
        return v
    }

    private val detailspanneauFragment = PanneauDetailsFragment()

    private fun replaceFragment(fragment : Fragment){
        if (fragment !=null){
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)
            transaction?.addToBackStack("Femerture")
            transaction?.commit()
        }
    }

    companion object {
        private val titrePanneau1 = "Les panneaux de danger"
        private val descPanneau1 = "Ce sont les panneaux de signalisation triangulaires."
        private  val img_1 = R.drawable.img_danger

        private val titrePanneau2 = "Les panneaux d'indication"
        private val descPanneau2 = "Ce sont des panneaux carrés. Ils ont souvent un fond bleu ou un fond blanc avec une bordure bleue. Ils peuvent indiquer des services, des installations, des zones, etc."
        private  val img_2 = R.drawable.img_indic

        private val titrePanneau3 = "Les panneaux d'interdiction"
        private val descPanneau3 = "Ce sont les panneaux ronds avec un fond blanc et une bordure rouge. Ils peuvent aussi avoir un fond rouge, comme le sens interdit. La fin d'interdiction est signalée par unpanneau rond à fond blanc."
        private  val img_3 = R.drawable.img_interdit

        private val titrePanneau4 = "Les panneaux d'obligation"
        private val descPanneau4 = "Ce sont aussi des panneaux ronds, à fond bleu cette fois. La fin d'obligation est un panneau identique barré de rouge."
        private  val img_4 = R.drawable.img_obligation

        private val titrePanneau5 = "Les panneaux de direction"
        private val descPanneau5 = "Ce sont des panneaux en forme de flèche, qui suivent un code couleur."
        private  val img_5 = R.drawable.img_direction

    }

}