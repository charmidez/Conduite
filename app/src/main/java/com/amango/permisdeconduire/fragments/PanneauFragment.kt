package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.GeneralAdapter
import com.amango.permisdeconduire.adapter.MyAdapter
import com.amango.permisdeconduire.data.DataCours
import com.amango.permisdeconduire.databinding.FragmentPanneauBinding
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauType
import com.amango.permisdeconduire.fragments.subfragment.PanneauDetailsFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class PanneauFragment : Fragment() {
    /*
* private var _binding: FragmentSuivietcBinding? = null
private val binding get() = _binding!!
*
* _binding = FragmentSuivietcBinding.inflate(inflater, container, false)
    val root: View = binding.root
* */
    private var _binding : FragmentPanneauBinding? = null
    private val binding get() = _binding!!

    private val detailspanneauFragment = PanneauDetailsFragment()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPanneauBinding.inflate(inflater,container,false)
        val root : View = binding.root
        //val v : View = inflater.inflate(R.layout.fragment_panneau, container, false)


        //MobileAds.initialize(root.context)
        //val adRequest = AdRequest.Builder().build()
        //v.adView_fragment_panneau_top.loadAd(adRequest)
        //v.adView_fragment_panneau_bottom.loadAd(adRequest)
        //binding.adViewFragmentPanneauBottom.loadAd(adRequest)

        //Part 2
        var recyclerView : RecyclerView
        val adapter_list : GeneralAdapter
        var itemList : ArrayList<DataCours>

        //Part 3
        recyclerView = binding.recyclerViewPanneau
        itemList = arrayListOf()
        itemList.add(DataCours("Titre ","Cours",""))
        itemList.add(DataCours("Titre 2","Cours 2",""))
        itemList.add(DataCours("Titre 3","Cours 2",""))
        adapter_list = GeneralAdapter(binding.root.context, itemList, 2)
        recyclerView.adapter = adapter_list



        //binding.listViewPanneau.adapter = adapter_list
        //v.listView_panneau.adapter = adapter_list
        /*
                binding.listViewPanneau.setOnItemClickListener {
                        adpterView, view, position, id ->
                    val bundles = Bundle()
                    val clickedPost = itemListPanneauType [position]
                    bundles.putString("titre", clickedPost.title)
                    bundles.putString("desc",clickedPost.desc)
                    clickedPost.id?.let { bundles.putInt("id", it) }
                    detailspanneauFragment.arguments = bundles
                    //replaceFragment(detailspanneauFragment)
                }

                v.listView_panneau.setOnItemClickListener {adpterView, view, position, id ->
                    val bundles = Bundle()
                    val clickedPost = itemListPanneauType [position]
                    bundles.putString("titre", clickedPost.title)
                    bundles.putString("desc",clickedPost.desc)
                    clickedPost.id?.let { bundles.putInt("id", it) }
                    detailspanneauFragment.arguments = bundles
                    replaceFragment(detailspanneauFragment)
                }

                 */
        return root
    }

    /*
private fun replaceFragment(fragment : Fragment){
    if (fragment !=null){
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}
*/
}