package com.example.tukitakirt.repositories
import com.example.tukitakirt.data.register.RequestUserRegister
import com.example.tukitakirt.services.user.UserServiceImpl
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject


//cs-26
class UserRepo  @Inject constructor(private  var service: UserServiceImpl ) {


    suspend fun  createUser(requestUserRegister: RequestUserRegister) : Task<Void> {

    return service.createUser(requestUserRegister)


    }


    //CS-34
    suspend fun getUserById(userId: String): DatabaseReference {
        return service.getUserById(userId)

    }






}