package com.example.tukitakirt.services.auth
import com.example.tukitakirt.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.mehedi.tukitalki.data.login.RequestUserLogin
import javax.inject.Inject

//CS-5

class AuthServiceImpl @Inject constructor(private val auth: FirebaseAuth): AuthService {
    override suspend fun register(request: RequestUserRegister): Task<AuthResult> {
     //CS-8
        return this.auth.createUserWithEmailAndPassword(request.email, request.password)


    }

    //cs-15
    override suspend fun login(request: RequestUserLogin): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(request.email, request.password)
    }
}