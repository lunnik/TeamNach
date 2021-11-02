package com.example.movie.domain

import com.example.domain.Either
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularFailure
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularResponse

interface MovieRepository {

    /** */
    suspend fun getMoviePopular(
    ): Either<GetMoviePopularFailure, GetMoviePopularResponse>
}