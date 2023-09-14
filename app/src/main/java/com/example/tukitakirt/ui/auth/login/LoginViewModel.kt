package com.example.tukitakirt.ui.auth.login
import RequestUserLogin
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tukitakirt.repositories.AuthRepo
import com.example.tukitakirt.utils.ErrorMessage
import com.example.tukitakirt.utils.SuccessMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


//CS-17
@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel()  {

    private var _resposne = MutableLiveData<String>()
    val responseLogin: LiveData<String> = _resposne


    fun login(
        request: RequestUserLogin
    ) {


        viewModelScope.launch {
            repo.login(request).addOnCompleteListener {

                if (it.isSuccessful) {
                    _resposne.postValue(SuccessMessage)
                }
//                else {
//                   // _resposne.postValue(rNNGzdBrXymtBL9WHZTXsLZrhihHoq9C9H)
//                   _resposne.postValue(it.exception?.localizedMessage ?: rNNGzdBrXymtBL9WHZTXsLZrhihHoq9C9H)
//
//                }


            }.addOnFailureListener {
                Log.d("TAG", "${it.localizedMessage}: ")


                _resposne.postValue(it.localizedMessage ?: ErrorMessage)

            }

        }


    }


}