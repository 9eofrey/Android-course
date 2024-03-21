package com.example.homework1.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel:ViewModel() {
    val email : MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
}