package com.amango.permisdeconduire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.amango.permisdeconduire.R
import kotlinx.android.synthetic.main.fragment_panneau.*
import kotlinx.android.synthetic.main.fragment_panneau.view.*

class PanneauFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v : View = inflater.inflate(R.layout.fragment_panneau, container, false)
        val listItem = mutableListOf("Julien", "Gabriel","Henok","Audrey","Sandra","Hervé","Gargarine","Oi", "Gabriel","Henok","Audrey","Sandra","Hervé","Gargarine","Oi")
        val arrayAdapter: ArrayAdapter<*>
       arrayAdapter = ArrayAdapter(  v.getContext(),android.R.layout.simple_list_item_1,listItem)
        v.listView_panneau.adapter = arrayAdapter

        return v
    }

}