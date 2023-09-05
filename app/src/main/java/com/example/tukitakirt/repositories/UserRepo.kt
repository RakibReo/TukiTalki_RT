package com.example.tukitakirt.repositories
import com.example.tukitakirt.data.register.RequestUserRegister
import com.example.tukitakirt.services.user.UserServiceImpl
import com.google.android.gms.tasks.Task
import javax.inject.Inject


//cs-26
class UserRepo  @Inject constructor(private  var service: UserServiceImpl ) {


    suspend fun  createUser(requestUserRegister: RequestUserRegister) : Task<Void> {

    return service.createUser(requestUserRegister)


    }






}