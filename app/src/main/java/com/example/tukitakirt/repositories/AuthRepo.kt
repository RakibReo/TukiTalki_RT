package com.example.tukitakirt.repositories

import RequestUserLogin
import com.example.tukitakirt.data.register.RequestUserRegister
import com.example.tukitakirt.services.auth.AuthServiceImpl
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

//Cs-9

class AuthRepo @Inject constructor(private var authService: AuthServiceImpl) {

    suspend fun registration(requestUserRegister: RequestUserRegister): Task<AuthResult> {

        return authService.register(requestUserRegister)

    }


    //cs-16
    suspend fun login(request: RequestUserLogin): Task<AuthResult> {
        return authService.login(request)
    }

}