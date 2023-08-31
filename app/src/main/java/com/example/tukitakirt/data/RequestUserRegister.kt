package com.example.tukitakirt.data


//Cs-3
data class RequestUserRegister(
    var userId: String = "",
    val name: String,
    val email: String,
    val password: String
)
