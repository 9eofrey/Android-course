package com.example.homework1.retrofit.model

data class ServerResponse(
    val status: String,
    val code:Int,
    val message:String?,
    val data : UserData?
)