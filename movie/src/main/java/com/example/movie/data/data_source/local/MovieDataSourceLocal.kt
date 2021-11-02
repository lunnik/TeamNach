package com.example.movie.data.data_source.local

import com.example.domain.Either
import com.example.movie.data.MovieDataSource
import com.example.movie.data.data_source.local.dao.MovieDao
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularFailure
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularResponse

internal class MovieDataSourceLocal(
    private val movieDao: MovieDao
) : MovieDataSource {

    /** */
    override suspend fun getMoviePopular():
            Either<GetMoviePopularFailure, GetMoviePopularResponse> =
        Either.Right(GetMoviePopularResponse( movieDao.getMoviePopular()))

}