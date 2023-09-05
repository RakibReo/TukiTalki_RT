package com.example.tukitakirt.services.user

import com.example.tukitakirt.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject


//cs-24
class UserServiceImpl  @Inject constructor(private  val dbRef: FirebaseDatabase): UserService {
    override suspend fun createUser(request: RequestUserRegister): Task<Void> {
       return dbRef.reference.child("user").child(request.userId).setValue(request)
    }


}