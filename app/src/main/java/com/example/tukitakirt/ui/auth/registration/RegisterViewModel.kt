package com.example.tukitakirt.ui.auth.registration

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tukitakirt.data.register.RequestUserRegister
import com.example.tukitakirt.repositories.AuthRepo
import com.example.tukitakirt.repositories.UserRepo
import com.example.tukitakirt.utils.ErrorMessage
import com.example.tukitakirt.utils.SuccessMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Cs-10

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repo: AuthRepo,
                                            private val userRepo: UserRepo)    //CS 27
    : ViewModel() {

    private var _resposne = MutableLiveData <String>()
    val responseRegistration: LiveData<String> = _resposne


    fun registration(requestUserRegister: RequestUserRegister) {


        viewModelScope.launch {
            repo.registration(requestUserRegister).addOnCompleteListener {

                //CS-12

                if (it.isSuccessful) {
                    requestUserRegister.userId= it.result.user!!.uid



                    viewModelScope.launch {
                        userRepo.createUser(requestUserRegister).addOnCompleteListener { dbIt ->

                            //CS27


                            if (dbIt.isSuccessful) {
                                _resposne.postValue(SuccessMessage)
                            } else {
                                _resposne.postValue(ErrorMessage)



                                _resposne.postValue(
                                    it.exception?.localizedMessage ?: ErrorMessage
                                )
                            }

                        }


                    }

                    //_resposne.postValue(successMessage)
                }



//                else {
//                   // _resposne.postValue(registrationErrorMessage)
//                   _resposne.postValue(it.exception?.localizedMessage ?: registrationErrorMessage)
//
//                }


            }.addOnFailureListener {

                Log.d("TAG", "${it.localizedMessage}: ")


                _resposne.postValue(it.localizedMessage ?: ErrorMessage)

            }

        }


    }



}