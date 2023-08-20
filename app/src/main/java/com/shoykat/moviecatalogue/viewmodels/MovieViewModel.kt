package com.shoykat.moviecatalogue.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoykat.moviecatalogue.models.PopularModel
import com.shoykat.moviecatalogue.models.TopratedModel
import com.shoykat.moviecatalogue.models.UpcomingModel
import com.shoykat.moviecatalogue.repos.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    val repository = MovieRepository()

    val popularMovieLiveData : MutableLiveData<PopularModel> = MutableLiveData()
    val upcomingMovieLiveData : MutableLiveData<UpcomingModel> = MutableLiveData()
    val topratedMovieLiveData : MutableLiveData<TopratedModel> = MutableLiveData()


    fun fetchData() {
        viewModelScope.launch {
            try {
                popularMovieLiveData.value = repository.fetchPopularMovieData()
                upcomingMovieLiveData.value = repository.fetchUpcomingMovieData()
                topratedMovieLiveData.value = repository.fetchTopratedMovieData()
            }catch (e: Exception) {
                 Log.d("MovieViewModel", e.localizedMessage)
            }
        }
    }
}