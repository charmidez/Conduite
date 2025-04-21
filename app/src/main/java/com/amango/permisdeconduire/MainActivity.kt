package com.amango.permisdeconduire

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.amango.permisdeconduire.databinding.ActivityMainBinding // Import the binding class
import com.amango.permisdeconduire.db.DataRepository
import com.amango.permisdeconduire.fragments.CoursesFragment
import com.amango.permisdeconduire.fragments.ExamenFragment
import com.amango.permisdeconduire.fragments.PanneauFragment
import com.amango.permisdeconduire.fragments.SettingFragment

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val coursesFragment = CoursesFragment()
    private val panneauFragment = PanneauFragment()
    private val examenFragment = ExamenFragment()
    private val settingFragment = SettingFragment()

    val repo = DataRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        /*
        repo.updateDataPanneau {
            binding.textViewChargement.visibility = View.INVISIBLE // Use binding
            replaceFragment(panneauFragment, getString(R.string.panneaux))
        }
         */

        repo.updateDataCours {
            binding.textViewChargement.visibility = View.INVISIBLE // Use binding
            replaceFragment(coursesFragment, getString(R.string.courses))
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem -> // Use menuItem
            when (menuItem.itemId) {
                R.id.item_course -> {
                    repo.updateDataCours {
                        binding.textViewChargement.visibility = View.INVISIBLE // Use binding
                        replaceFragment(coursesFragment, getString(R.string.courses))
                    }
                }

                R.id.item_panneau -> {
                    repo.updateDataPanneau {
                        binding.textViewChargement.visibility = View.INVISIBLE // Use binding
                        replaceFragment(panneauFragment, getString(R.string.panneaux))
                    }
                }

                R.id.item_exam -> {
                    binding.textViewChargement.visibility = View.INVISIBLE // Use binding
                    replaceFragment(examenFragment, getString(R.string.exam))
                }

                R.id.item_setting -> {
                    binding.textViewChargement.visibility = View.INVISIBLE // Use binding
                    replaceFragment(settingFragment, getString(R.string.settings))
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, title_fragment: String) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            binding.textViewTitleFragment.text = title_fragment // Use binding and .text
            transaction.commit()
        }
    }
}