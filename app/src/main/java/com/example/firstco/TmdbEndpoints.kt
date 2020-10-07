package com.example.firstco

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbEndpoints {

    @GET("users/octokit/repos")
    fun getMovies(@Query("api_key") key: String): Call<PopularMovies>

}

data class PopularMovies(
    val results: List<Result>
)

data class Result(
    val id: Int,
    val node_id: String,
    val name: String,
    val full_name: String,
    val private: Boolean
)