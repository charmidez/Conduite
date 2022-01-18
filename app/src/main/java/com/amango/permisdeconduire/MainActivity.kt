package com.amango.permisdeconduire

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.amango.permisdeconduire.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val coursesFragment = CoursesFragment()
    private val panneauFragment = PanneauFragment()
    private val examenFragment = ExamenFragment()
    private val settingFragment = SettingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment,"Accueil")

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_home -> replaceFragment(homeFragment, "Accueil" )
                R.id.item_course -> replaceFragment(coursesFragment, "Cours")
                R.id.item_panneau -> replaceFragment(panneauFragment,"Panneaux Routiers" )
                R.id.item_exam -> replaceFragment(examenFragment,"Examen")
                R.id.item_setting -> replaceFragment(settingFragment,"Reglages")
            }
            true
        }

    }

    private fun replaceFragment(fragment : Fragment, title_fragment : String){

        if (fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
        textView_title_fragment.setText(title_fragment)
    }
}