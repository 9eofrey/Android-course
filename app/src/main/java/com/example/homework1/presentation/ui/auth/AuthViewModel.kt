package com.example.homework1.presentation.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel:ViewModel() {
   private val _email : MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val email:LiveData<String> = _email
    init {
        _email.value = ""
    }

    fun addData(email:String){
      _email.value = email

    }
}