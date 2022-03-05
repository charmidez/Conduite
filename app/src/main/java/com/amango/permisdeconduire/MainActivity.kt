package com.amango.permisdeconduire

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.amango.permisdeconduire.db.DataRepository
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemExam
import com.amango.permisdeconduire.fragments.*
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //private val coursesFragment = CoursesFragment()
    private val panneauFragment = PanneauFragment()
    private val examenFragment = ExamenFragment()
    private val settingFragment = SettingFragment()

    //Chargement de notre repository
    val repo = DataRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mobile ads
        MobileAds.initialize(this@MainActivity)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView.adListener = object : AdListener() {
        }

        //mise à jour de la base de donnée
        repo.updateData {
            textView_chargement.visibility = View.INVISIBLE
            replaceFragment(panneauFragment, "Panneaux Routiers")
            bottom_navigation.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.item_panneau -> {
                        replaceFragment(panneauFragment, "Panneaux Routiers")
                    }
                    R.id.item_exam -> {
                        replaceFragment(examenFragment, "Examen")
                    }
                    R.id.item_setting -> {
                        replaceFragment(settingFragment, "Reglages")
                    }
                }
                true
            }
        }
    }

    private fun replaceFragment(fragment : Fragment, title_fragment : String){
            if (fragment !=null){
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                textView_title_fragment.setText(title_fragment)
                transaction.commit()
            }
    }
}
