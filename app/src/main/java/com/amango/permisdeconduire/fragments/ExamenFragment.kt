package com.amango.permisdeconduire.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amango.permisdeconduire.R
import com.amango.permisdeconduire.adapter.MyGridAdapter
import com.amango.permisdeconduire.data.DataGridChar
import com.amango.permisdeconduire.databinding.FragmentExamenBinding
import com.amango.permisdeconduire.fragments.subfragment.ExamenQuizzFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class ExamenFragment : Fragment() {

    private var _binding : FragmentExamenBinding? = null
    private val binding get() = _binding!!

    private var examenQuizzFragment = ExamenQuizzFragment()

    private fun setDataChar() : ArrayList<DataGridChar>{
        var charValues : ArrayList<DataGridChar> = ArrayList()
        charValues.add(DataGridChar("A",1))
        charValues.add(DataGridChar("B",2))
        charValues.add(DataGridChar("C",41))
        charValues.add(DataGridChar("D",61))
        charValues.add(DataGridChar("E",81))
        charValues.add(DataGridChar("F",101))
        charValues.add(DataGridChar("G",121))
        charValues.add(DataGridChar("H",141))
        charValues.add(DataGridChar("I",161))
        charValues.add(DataGridChar("J",181))
        charValues.add(DataGridChar("K",201))
        charValues.add(DataGridChar("L",221))
        charValues.add(DataGridChar("M",241))
        charValues.add(DataGridChar("N",261))
        charValues.add(DataGridChar("O",281))
        charValues.add(DataGridChar("P",301))
        charValues.add(DataGridChar("Q",321))
        charValues.add(DataGridChar("R",341))
        charValues.add(DataGridChar("S",361))
        charValues.add(DataGridChar("T",401))
        charValues.add(DataGridChar("U",421))
        charValues.add(DataGridChar("V",441))
        charValues.add(DataGridChar("W",461))
        charValues.add(DataGridChar("X",481))
        charValues.add(DataGridChar("Y",501))
        charValues.add(DataGridChar("Z",521))

        return charValues
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  {
        _binding = FragmentExamenBinding.inflate(inflater,container,false)
        val root : View = binding.root

        var myGridAdapter : MyGridAdapter

        var charValues : ArrayList<DataGridChar>

        charValues = setDataChar()
        myGridAdapter = MyGridAdapter(root.context,charValues!!)
        binding.gridViewLayoutId.adapter = myGridAdapter
        binding.gridViewLayoutId.setOnItemClickListener { parent, view, position, id ->
            val bundles = Bundle()
            val clickedId = charValues[position]
            clickedId.niveau.let { bundles.putInt("niveau", it!!) }
        }
        return root
    }


}

