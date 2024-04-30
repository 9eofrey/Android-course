package com.example.homework1.retrofit

import com.example.homework1.retrofit.model.AuthUser
import retrofit2.http.Body
import retrofit2.http.POST

interface WebRequestListener {
    @POST("users")
    suspend fun authorizeUser(@Body authUser: AuthUser)
}