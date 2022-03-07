package com.amango.permisdeconduire.db

import com.amango.permisdeconduire.data.Data
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbCoursesList
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbPanneauDangerList
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbPanneauDirectionList
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbPanneauIndicationList
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbPanneauInterditList
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbPanneauObligationList
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbQuizzQuestion
import com.amango.permisdeconduire.db.DataRepository.Singleton.dbtypePanneau
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemExam
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListCourses
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauDanger
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauDirection
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauIndication
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauInterdit
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauObligation
import com.amango.permisdeconduire.db.DataRepository.Singleton.itemListPanneauType
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DataRepository {

    object Singleton {
        val dbtypePanneau = FirebaseDatabase.getInstance().getReference("Panneaux")
        val dbCoursesList = FirebaseDatabase.getInstance().getReference("Cours")
        val dbQuizzQuestion = FirebaseDatabase.getInstance().getReference("Examen")

        val itemListPanneauType = arrayListOf<Data>()
        val itemListCourses = arrayListOf<Data>()
        val itemExam = arrayListOf<Data>()


        val dbPanneauDangerList = FirebaseDatabase.getInstance().getReference("Danger")
        val dbPanneauObligationList = FirebaseDatabase.getInstance().getReference("Obligation")
        val dbPanneauInterditList = FirebaseDatabase.getInstance().getReference("Interdit")
        val dbPanneauDirectionList = FirebaseDatabase.getInstance().getReference("Direction")
        val dbPanneauIndicationList = FirebaseDatabase.getInstance().getReference("Indication")

        val itemListPanneauDanger = arrayListOf<Data>()
        val itemListPanneauObligation = arrayListOf<Data>()
        val itemListPanneauInterdit = arrayListOf<Data>()
        val itemListPanneauDirection = arrayListOf<Data>()
        val itemListPanneauIndication = arrayListOf<Data>()
    }
    /*
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

            //les question in quizz
            dbQuizzQuestion.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    //faire le ménage
                    itemExam .clear()
                    //recolter la liste
                    for (ds in snapshot.children){
                        //Construction d'une donnée
                        val data = ds.getValue(Data::class.java)
                        //is it null ?
                        if(data !=null){
                            itemExam.add(data)
                        }
                    }
                    //le callback
                    callback()
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })

        }
    */

    fun updateDataCours(callback: () -> Unit){
        dbCoursesList.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                itemListCourses .clear()
                for (ds in snapshot.children){
                    val data = ds.getValue(Data::class.java)
                    if(data !=null){
                        itemListCourses .add(data)
                    }
                }
                callback()
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    fun updateDataPanneau(callback: () -> Unit){
        dbtypePanneau.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                itemListPanneauType.clear()
                for (ds in snapshot.children){
                    val data = ds.getValue(Data::class.java)
                    if(data !=null){
                        itemListPanneauType.add(data)
                    }
                }
                callback()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
    fun updateDataQuizzQuestion(callback: () -> Unit){
        dbQuizzQuestion.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                itemExam .clear()
                for (ds in snapshot.children){
                    val data = ds.getValue(Data::class.java)
                    if(data !=null){
                        itemExam.add(data)
                    }
                }
                callback()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    fun updateDataPanneauDanger(callback: () -> Unit){
        dbPanneauDangerList.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                itemListPanneauDanger .clear()
                for (ds in snapshot.children){
                    val data = ds.getValue(Data::class.java)
                    if(data !=null){ itemListPanneauDanger .add(data) }
                }
                callback()
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
    fun updateDataPanneauObligation(callback: () -> Unit){
        dbPanneauObligationList.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                itemListPanneauObligation.clear()
                for (ds in snapshot.children){
                    val data = ds.getValue(Data::class.java)
                    if (data!=null){ itemListPanneauObligation.add(data)}
                }
                callback()
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
    fun updateDataPanneauDirection(callback: () -> Unit){
        dbPanneauDirectionList.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                itemListPanneauDirection.clear()
                for (ds in snapshot.children){
                    val data = ds.getValue(Data::class.java)
                    if(data!=null){ itemListPanneauDirection.add(data)}
                }
                callback()
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    fun updateDataPanneauInterdit(callback: () -> Unit){
        dbPanneauInterditList.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                itemListPanneauInterdit.clear()
                for (ds in snapshot.children){
                    val data = ds.getValue(Data::class.java)
                    if (data!=null){ itemListPanneauInterdit.add(data)}
                }
                callback()
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    fun updateDataPanneauIndication(callback: () -> Unit){
        dbPanneauIndicationList.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                itemListPanneauIndication.clear()
                for (ds in snapshot.children){
                    val data = ds.getValue(Data::class.java)
                    if (data!=null){ itemListPanneauIndication.add(data)}
                }
                callback()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

}