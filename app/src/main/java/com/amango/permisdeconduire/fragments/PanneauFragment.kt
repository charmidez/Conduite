package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.MyAdapter
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauType
import com.amango.permisdeconduire.fragments.subfragment.PanneauDetailsFragment
import kotlinx.android.synthetic.main.fragment_panneau.view.*

class PanneauFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v : View = inflater.inflate(R.layout.fragment_panneau, container, false)

        //Part 2
        val adapter_list : MyAdapter

        //Part 3
        adapter_list = MyAdapter(v.context, R.layout.item_panneau_type,itemListPanneauType)
        v.listView_panneau.adapter = adapter_list


        v.listView_panneau.setOnItemClickListener {adpterView, view, position, id ->
            val bundles = Bundle()
            val clickedPost = itemListPanneauType [position]
            bundles.putString("titre", clickedPost.title)
            bundles.putString("desc",clickedPost.desc)
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
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }
}