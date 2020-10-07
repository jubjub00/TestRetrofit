package com.example.firstco.TestApi
import java.util.List
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("users")
    fun getAllUser():Call<List<User>>
}