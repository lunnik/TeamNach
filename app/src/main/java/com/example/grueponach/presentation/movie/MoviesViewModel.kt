package com.example.grueponach.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularParams
import com.example.movie.presentation.get_movie_popular.GetMoviePopular
import com.example.movie.presentation.get_movie_popular.MoviePopularStatus

class MoviesViewModel (
    getMoviePopular: GetMoviePopular
) : ViewModel(),
    GetMoviePopular by getMoviePopular {

    /** */
    fun getMoviePopularAsLiveData(
    ): LiveData<MoviePopularStatus> {
        val params = GetMoviePopularParams
        return getMoviePopularAsLiveData(params)
    }

}