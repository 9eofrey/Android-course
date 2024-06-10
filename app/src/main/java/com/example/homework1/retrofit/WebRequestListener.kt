package com.example.homework1.retrofit

import com.example.homework1.retrofit.model.AuthUser
import com.example.homework1.retrofit.model.EditUser
import com.example.homework1.retrofit.model.LoginUser
import com.example.homework1.retrofit.model.ServerResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface WebRequestListener {
    @POST("users")
    suspend fun authorizeUser(@Body authUser: AuthUser):ServerResponse
   @PUT
    suspend fun editUser(@Body editUser: EditUser):ServerResponse

    @POST("login")
    suspend fun loginUser(@Body loginUser: LoginUser):ServerResponse
}