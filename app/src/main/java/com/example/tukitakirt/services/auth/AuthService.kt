package com.example.tukitakirt.services.auth
import RequestUserLogin
import com.example.tukitakirt.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult


//cs-4

interface AuthService {

    suspend fun register(request: RequestUserRegister): Task<AuthResult>

    //cs-14
    suspend fun login(request: RequestUserLogin): Task<AuthResult>

}