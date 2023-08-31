package com.example.tukitakirt.services

import com.example.tukitakirt.data.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

//CS-5

class AuthServiceImpl @Inject constructor(private val auth: FirebaseAuth): AuthService {
    override suspend fun register(request: RequestUserRegister): Task<AuthResult> {
     //CS-8
        return this.auth.createUserWithEmailAndPassword(request.email, request.password)


    }
}