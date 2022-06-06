package com.amango.permisdeconduire.fragments.subfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.MyAdapter
import com.amango.permisdeconduire.db.DataRepository
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauDanger
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauDirection
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauIndication
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauInterdit
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauObligation
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_panneau_details.view.*

class PanneauDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_panneau_details, container, false)
        val repo = DataRepository()

        MobileAds.initialize(v.context)
        val adRequest = AdRequest.Builder().build()
        v.adView_fragment_panneau_details_bottom.loadAd(adRequest)
        v.adView_fragment_panneau_details_top.loadAd(adRequest)

        val args = this.arguments
        var idTypePanneaux = args?.getInt("id")
        v.textView_titre_categorie_panneau.text  = args?.get("titre").toString()

        var adapter_list : MyAdapter
        when(idTypePanneaux){
            1 -> {
                repo.updateDataPanneauDanger {
                    adapter_list = MyAdapter(v.context, R.layout.item_panneau,itemListPanneauDanger)
                    v.panneau_details_listView.adapter = adapter_list
                }
            }
            2 -> {
                repo.updateDataPanneauIndication {
                    adapter_list = MyAdapter(v.context, R.layout.item_panneau, itemListPanneauIndication)
                    v.panneau_details_listView.adapter = adapter_list
                }
            }
            3 -> {
                repo.updateDataPanneauInterdit {
                    adapter_list = MyAdapter(v.context, R.layout.item_panneau, itemListPanneauInterdit)
                    v.panneau_details_listView.adapter = adapter_list
                }
            }
            4 -> {
                repo.updateDataPanneauObligation {
                    adapter_list = MyAdapter(v.context, R.layout.item_panneau, itemListPanneauObligation)
                    v.panneau_details_listView.adapter = adapter_list
                }
            }
            5 -> {
                repo.updateDataPanneauDirection {
                    adapter_list = MyAdapter(v.context, R.layout.item_panneau, itemListPanneauDirection)
                    v.panneau_details_listView.adapter = adapter_list
                }
            }
        }
        return v
    }

}