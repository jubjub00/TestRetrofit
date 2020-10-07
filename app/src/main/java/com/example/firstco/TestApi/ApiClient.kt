package com.example.firstco.TestApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    fun getRetrofit():Retrofit{
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("http://api.larntech.net/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

    fun getUser() : UserService{
        val userService:UserService = getRetrofit().create(UserService::class.java)
        return userService
    }
}