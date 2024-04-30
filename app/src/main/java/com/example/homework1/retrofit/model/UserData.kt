package com.example.homework1.retrofit.model

import com.example.homework1.data.Contact

data class UserData(
    //TODO: replace Contact with model from API(firstly need to understand what model)
    val user:Contact,
    val accessToken:String,
    val refreshToken:String
)
