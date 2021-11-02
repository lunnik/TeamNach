package com.example.movie.data

import com.example.domain.Either
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularFailure
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularResponse


/** */
internal interface MovieDataSource {

    /** */
    suspend fun getMoviePopular(
    ): Either<GetMoviePopularFailure, GetMoviePopularResponse>

}