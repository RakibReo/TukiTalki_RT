package com.example.tukitakirt.utils


import com.google.firebase.database.FirebaseDatabase

fun FirebaseDatabase.instance(): FirebaseDatabase {
    return FirebaseDatabase.getInstance()

}