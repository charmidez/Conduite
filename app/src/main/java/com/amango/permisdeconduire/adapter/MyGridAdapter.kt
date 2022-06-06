package com.amango.permisdeconduire.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.data.DataGridChar
import kotlinx.android.synthetic.main.item_grid.view.*

class MyGridAdapter(
    var mContext : Context,
    var charValues : ArrayList<DataGridChar>) : BaseAdapter() {

    override fun getCount(): Int {
        return charValues.size
    }

    override fun getItem(position: Int): Any {
        return charValues.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v : View = View.inflate(mContext, R.layout.item_grid,null)
        var charAlphabet : DataGridChar = charValues.get(position)
        v.textView_grid_stage.text = charAlphabet.alphabet

        return v
    }

}