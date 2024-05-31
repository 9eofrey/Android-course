package com.example.homework1.retrofit.model

data class ResponseUserData (
    val email:String,
    val name:String?,
    val phone:Int?,
    val address:String?,
    val career:String?,
    val birthday:Int?,
    val facebook:String?,
    val instagram:String?,
    val twitter:String?,
    val linkedin:String?,
    val image:String?,
    val updatedAt:String,
    val createdAt:String,
    val id:Int
)