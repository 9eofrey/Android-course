package com.example.homework1.retrofit.model

import com.example.homework1.data.Contact

data class UserData(
    val user:ResponseUserData,
    val accessToken:String?,
    val refreshToken:String?
)
