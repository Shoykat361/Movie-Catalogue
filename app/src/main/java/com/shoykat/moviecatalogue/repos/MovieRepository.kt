package com.shoykat.moviecatalogue.repos

import com.shoykat.moviecatalogue.NetworkService
import com.shoykat.moviecatalogue.models.PopularModel
import com.shoykat.moviecatalogue.models.TopratedModel
import com.shoykat.moviecatalogue.models.UpcomingModel

class MovieRepository {
    suspend fun fetchPopularMovieData(): PopularModel {
        val endUrl = "movie/popular?api_key=8751fd25eb0bf4e46c8f1198f93d0163"
        return NetworkService.movieServiceApi
            .getPopularMovie(endUrl)
    }
    suspend fun fetchUpcomingMovieData(): UpcomingModel {
        val endUrl = "movie/top_rated?api_key=8751fd25eb0bf4e46c8f1198f93d0163"
        return NetworkService.movieServiceApi
            .getUpcomingMovie(endUrl)
    }
    suspend fun fetchTopratedMovieData(): TopratedModel {
        val endUrl = "movie/upcoming?api_key=8751fd25eb0bf4e46c8f1198f93d0163"
        return NetworkService.movieServiceApi
            .getTopratedMovie(endUrl)
    }

}