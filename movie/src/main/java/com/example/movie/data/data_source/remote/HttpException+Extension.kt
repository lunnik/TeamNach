package com.example.movie.data.data_source

import com.example.data_source.data_source.remote.model.HttpErrorCode
import com.example.data_source.data_source.remote.model.errorMessage
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularFailure
import retrofit2.HttpException

/**
 *
 */
internal fun HttpException.toGetMoviePopularFailure(): GetMoviePopularFailure =
    when (HttpErrorCode.fromCode(code())) {
        HttpErrorCode.BAD_REQUEST -> GetMoviePopularFailure.UserDisabled
        else -> GetMoviePopularFailure.ServerFailure(code(), errorMessage())
    }
