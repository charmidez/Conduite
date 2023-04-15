package com.amango.permisdeconduire

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.amango.permisdeconduire.databinding.ActivityMainBinding
import com.amango.permisdeconduire.db.DataRepository
import com.amango.permisdeconduire.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val coursesFragment = CoursesFragment()
    private val panneauFragment = PanneauFragment()
    private val examenFragment = ExamenFragment()
    private val settingFragment = SettingFragment()

    val repo = DataRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        /*
        var txtView_chargment : TextView = findViewById(R.id.textView_chargement)
        var bottomBar : BottomNavigationView = findViewById(R.id.bottom_navigation)

                repo.updateDataPanneau {
                    txtView_chargment.visibility = View.INVISIBLE
                    replaceFragment(panneauFragment, getString(R.string.panneaux))
                }

                bottomBar.setOnNavigationItemSelectedListener {
                        when(it.itemId){
                            R.id.item_course -> {
                                repo.updateDataCours {
                                    replaceFragment(coursesFragment, getString(R.string.courses))
                                }
                            }
                            R.id.item_panneau -> {
                                repo.updateDataPanneau {
                                    txtView_chargment.visibility = View.INVISIBLE
                                    replaceFragment(panneauFragment, getString(R.string.panneaux))
                                }
                            }
                            R.id.item_exam -> {
                                txtView_chargment.visibility = View.INVISIBLE
                                replaceFragment(examenFragment, getString(R.string.exam))
                            }
                            R.id.item_setting -> {
                                txtView_chargment.visibility = View.INVISIBLE
                                replaceFragment(settingFragment, getString(R.string.settings))
                            }
                        }
                        true
                    }
*/

        val navView: BottomNavigationView = binding.bottomNavigation
        val navController = findNavController(R.id.nav_host_fragment_contenair_activity_main)
        navView.setupWithNavController(navController)




    }


    /*
    private fun replaceFragment(fragment : Fragment, title_fragment : String){
            if (fragment !=null){
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                var txtView_title_fragment : TextView = findViewById(R.id.textView_title_fragment)
                txtView_title_fragment.setText(title_fragment)
                transaction?.addToBackStack(parentActivityIntent.toString())
                transaction.commit()
            }
    }
    */


}
