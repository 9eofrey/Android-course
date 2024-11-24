package com.example.homework1.presentation.uitl.ext.singletones

import com.example.homework1.retrofit.WebRequestListener
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    val retrofit = Retrofit.Builder()
        .baseUrl("http://178.63.9.114:7777/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    val api = retrofit.create(WebRequestListener::class.java)
}