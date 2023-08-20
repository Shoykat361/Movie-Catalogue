package com.shoykat.moviecatalogue

import com.shoykat.moviecatalogue.models.PopularModel
import com.shoykat.moviecatalogue.models.TopratedModel
import com.shoykat.moviecatalogue.models.UpcomingModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


const val movie_api_key = "8751fd25eb0bf4e46c8f1198f93d0163"
const val  movie_api_access_Token ="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NzUxZmQyNWViMGJmNGU0NmM4ZjExOThmOTNkMDE2MyIsInN1YiI6IjY0ZTFlMjJjMzcxMDk3MDEzOTQ5NDFkNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.04IbbVAzyRDopXKk09px909d-Pa7wdU-dDorIoFRk8M"
const val base_url = "https://api.themoviedb.org/3/"
const val image_url = "https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg"

//retrofit object
val retrofit= Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

//endUrl interface method
interface MovieServiceApi{
    @GET
    suspend fun getPopularMovie(@Url endUrl: String) : PopularModel

    @GET
    suspend fun getUpcomingMovie(@Url endUrl: String) : UpcomingModel

    @GET
    suspend fun getTopratedMovie(@Url endUrl: String) : TopratedModel
}

//interface object
object NetworkService {
    val movieServiceApi:MovieServiceApi by lazy {
        retrofit.create(MovieServiceApi::class.java)
    }
}
