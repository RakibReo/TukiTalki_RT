package com.example.tukitakirt.services

import com.example.tukitakirt.data.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult


//cs-4

interface AuthService {

    suspend fun register(request: RequestUserRegister): Task<AuthResult>

}