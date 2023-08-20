package com.shoykat.moviecatalogue


import com.shoykat.moviecatalogue.models.GetMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "8751fd25eb0bf4e46c8f1198f93d0163",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "8751fd25eb0bf4e46c8f1198f93d0163",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "8751fd25eb0bf4e46c8f1198f93d0163",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}