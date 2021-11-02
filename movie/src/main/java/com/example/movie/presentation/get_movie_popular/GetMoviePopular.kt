package com.example.movie.presentation.get_movie_popular

import androidx.lifecycle.LiveData
import com.example.domain.Either
import com.example.domain.presentation.Status
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularFailure
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularParams
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularResponse

/* */
typealias MoviePopularStatus = Status<GetMoviePopularFailure, GetMoviePopularResponse>

interface GetMoviePopular {
    /* */
    var getMoviePopularFailure: GetMoviePopularFailure

    /* */
    var getMoviePopularResponse: GetMoviePopularResponse


    /** */
    fun getMoviePopularAsLiveData(
        params: GetMoviePopularParams
    ): LiveData<MoviePopularStatus>

    /** */
    suspend fun getMoviePopularAsEither(
        params: GetMoviePopularParams
    ): Either<GetMoviePopularFailure, GetMoviePopularResponse>
}