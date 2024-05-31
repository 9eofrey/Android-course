package com.example.homework1.retrofit.model

data class AuthUser(
    val email:String,
    val password:String,
    val name:String?,
    val phone:Int?,
    val address:String?,
    val career:String?,
    val birthday:Int?,
    val facebook:String?,
    val instagram:String?,
    val twitter:String?,
    val linkedin:String?,
    val image:String?
)