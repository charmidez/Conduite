package com.amango.permisdeconduire

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.amango.permisdeconduire.db.DataRepository
import com.amango.permisdeconduire.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val coursesFragment = CoursesFragment()
    private val panneauFragment = PanneauFragment()
    private val examenFragment = ExamenFragment()
    private val settingFragment = SettingFragment()

    val repo = DataRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repo.updateDataPanneau {
            textView_chargement.visibility = View.INVISIBLE
            replaceFragment(panneauFragment, getString(R.string.panneaux))
        }
            bottom_navigation.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.item_course -> {
                        repo.updateDataCours {
                            replaceFragment(coursesFragment, getString(R.string.courses))
                        }
                    }
                    R.id.item_panneau -> {
                        repo.updateDataPanneau {
                            textView_chargement.visibility = View.INVISIBLE
                            replaceFragment(panneauFragment, getString(R.string.panneaux))
                        }
                    }
                    R.id.item_exam -> {
                        textView_chargement.visibility = View.INVISIBLE
                        replaceFragment(examenFragment, getString(R.string.exam))
                    }
                    R.id.item_setting -> {
                        textView_chargement.visibility = View.INVISIBLE
                        replaceFragment(settingFragment, getString(R.string.settings))
                    }
                }
                true
            }
    }

    private fun replaceFragment(fragment : Fragment, title_fragment : String){
            if (fragment !=null){
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                textView_title_fragment.setText(title_fragment)
                transaction?.addToBackStack(parentActivityIntent.toString())
                transaction.commit()
            }
    }
}
