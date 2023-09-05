package com.example.tukitakirt.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//CS-7

@Module
@InstallIn(SingletonComponent::class)
class FireBaseProvider {

    @Provides
    @Singleton
    fun provideAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }


    //CS-25

    @Provides
    @Singleton
    fun provideDb(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

}