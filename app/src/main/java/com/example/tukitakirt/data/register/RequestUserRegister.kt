package com.example.tukitakirt.data.register

//Cs-3
data class RequestUserRegister(
    var userId: String = "",
    val name: String,
    val password: String,
    //CS-21
    var createdAt: Long?=null,
    var updatedAt: Long?=null,
    var image: String="",
    val email: String,     //cs-3
    var about: String="",
    var token :String="",
    var mobile: String?=null
)
