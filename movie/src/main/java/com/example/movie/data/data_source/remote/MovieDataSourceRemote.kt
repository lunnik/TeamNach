package com.example.movie.data.data_source.remote

import com.example.data_source.data_source.remote.model.retrofitApiCall
import com.example.domain.Either
import com.example.movie.data.MovieDataSource
import com.example.movie.data.data_source.local.dao.MovieDao
import com.example.movie.data.data_source.toGetMoviePopularFailure
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularFailure
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularResponse
import retrofit2.HttpException
import timber.log.Timber
import com.example.data_source.data_source.exception.message

internal class MovieDataSourceRemote(
    private val movieApiServices: MovieApiServices,
    private val movieDao: MovieDao
) : MovieDataSource {

    /** */
    override suspend fun getMoviePopular():
            Either<GetMoviePopularFailure, GetMoviePopularResponse> =
        try {
            retrofitApiCall {
                val apiKey = "0a05362c0528a291af53ffd6bb8f64c7"
                movieApiServices.getMoviePopular(apiKey)
            }.let {
                movieDao.createMovieResult(it.toMovie().results)
                Either.Right(GetMoviePopularResponse(it.toMovie().results))
            }
        } catch (exception: Exception) {
            Timber.e(exception)
            val failure: GetMoviePopularFailure = when (exception) {
                is HttpException -> exception.toGetMoviePopularFailure()
                else -> GetMoviePopularFailure.UnknownFailure(exception.message())
            }
            Either.Left(failure)
        }
}