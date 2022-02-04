package com.amango.permisdeconduire

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.amango.permisdeconduire.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_courses.*
import kotlinx.android.synthetic.main.item_courses.*

class MainActivity : AppCompatActivity() {

    private val coursesFragment = CoursesFragment()
    private val panneauFragment = PanneauFragment()
    private val examenFragment = ExamenFragment()
    private val settingFragment = SettingFragment()

    //private  lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
                //navController = navHostFragment.navController

        replaceFragment(coursesFragment,"Cours")
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
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
            textView_title_fragment.setText(title_fragment)
            transaction.commit()
        }
    }


}