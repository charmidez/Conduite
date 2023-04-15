package com.amango.permisdeconduire.fragments.subfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.MyAdapter
import com.amango.permisdeconduire.databinding.FragmentPanneauDetailsBinding
import com.amango.permisdeconduire.db.DataRepository
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauDanger
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauDirection
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauIndication
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauInterdit
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauObligation
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class PanneauDetailsFragment : Fragment() {

    /*
* private var _binding: FragmentSuivietcBinding? = null
private val binding get() = _binding!!
*
* _binding = FragmentSuivietcBinding.inflate(inflater, container, false)
val root: View = binding.root
* */

    private var _binding : FragmentPanneauDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPanneauDetailsBinding.inflate(inflater,container,false)
        val root : View = binding.root
        var txtView_titre_categories_panneau = binding.textViewTitreCategoriePanneau
        var listView_panneau_details = binding.panneauDetailsListView
        //val v = inflater.inflate(R.layout.fragment_panneau_details, container, false)
        val repo = DataRepository()

        MobileAds.initialize(root.context)
        val adRequest = AdRequest.Builder().build()
        binding.adViewFragmentPanneauDetailsBottom.loadAd(adRequest)
        binding.adViewFragmentPanneauDetailsTop.loadAd(adRequest)

        val args = this.arguments
        var idTypePanneaux = args?.getInt("id")
        txtView_titre_categories_panneau.text  = args?.get("titre").toString()

        var adapter_list : MyAdapter
        when(idTypePanneaux){
            1 -> {
                repo.updateDataPanneauDanger {
                    adapter_list = MyAdapter(root.context, R.layout.item_panneau,itemListPanneauDanger)
                    listView_panneau_details.adapter = adapter_list
                }
            }
            2 -> {
                repo.updateDataPanneauIndication {
                    adapter_list = MyAdapter(root.context, R.layout.item_panneau, itemListPanneauIndication)
                    listView_panneau_details.adapter = adapter_list
                }
            }
            3 -> {
                repo.updateDataPanneauInterdit {
                    adapter_list = MyAdapter(root.context, R.layout.item_panneau, itemListPanneauInterdit)
                    listView_panneau_details.adapter = adapter_list
                }
            }
            4 -> {
                repo.updateDataPanneauObligation {
                    adapter_list = MyAdapter(root.context, R.layout.item_panneau, itemListPanneauObligation)
                    listView_panneau_details.adapter = adapter_list
                }
            }
            5 -> {
                repo.updateDataPanneauDirection {
                    adapter_list = MyAdapter(root.context, R.layout.item_panneau, itemListPanneauDirection)
                    listView_panneau_details.adapter = adapter_list
                }
            }
        }
        return root
    }

}