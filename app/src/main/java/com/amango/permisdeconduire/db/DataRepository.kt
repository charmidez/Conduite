package com.amango.permisdeconduire.db

import com.amango.permisdeconduire.data.Data
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbCoursesList
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbPanneauDangerList
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbtypePanneau
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListCourses
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauDanger
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauType
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DataRepository {

    object Singleton {
        //se connecter à la base de donnée et aux références qui sont dedans.
        val dbtypePanneau = FirebaseDatabase.getInstance().getReference("Panneaux")
        val dbCoursesList = FirebaseDatabase.getInstance().getReference("Cours")
        val dbPanneauDangerList = FirebaseDatabase.getInstance().getReference("Danger")

        //créér une listPanneau
        val itemListPanneauType = arrayListOf<Data>()
        val itemListCourses = arrayListOf<Data>()
        val itemListPanneauDanger = arrayListOf<Data>()
    }
        fun updateData(callback : () -> Unit) {

            //absorber la données de la base de donnée et les donner à ma list de type de panneaux
            dbtypePanneau.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    itemListPanneauType.clear()
                    //recolter la liste
                    for (ds in snapshot.children){
                        //Construction d'une donnée
                        val data = ds.getValue(Data::class.java)
                        //is it null ?
                        if(data !=null){
                            itemListPanneauType.add(data)
                        }
                    }
                    //le callback
                    callback()
                }
                override fun onCancelled(error: DatabaseError) {
                }
            })

            // absorber la liste des cours
            dbCoursesList.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    //faire le ménage
                    itemListCourses .clear()

                    //recolter la liste
                    for (ds in snapshot.children){
                        //Construction d'une donnée
                        val data = ds.getValue(Data::class.java)

                        //is it null ?
                        if(data !=null){
                            itemListCourses .add(data)
                        }
                    }
                    //le callback
                    callback()
                }
                override fun onCancelled(error: DatabaseError) {

                }

            })

            //absorber les panneaux seul à seul
            dbPanneauDangerList.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    //faire le ménage
                    itemListPanneauDanger .clear()

                    //recolter la liste
                    for (ds in snapshot.children){
                        //Construction d'une donnée
                        val data = ds.getValue(Data::class.java)

                        //is it null ?
                        if(data !=null){
                            itemListPanneauDanger .add(data)
                        }
                    }
                    //le callback
                    callback()
                }
                override fun onCancelled(error: DatabaseError) {

                }
            })

        }
}