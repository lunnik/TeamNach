package com.example.movie.data

import com.example.domain.Either
import com.example.movie.data.data_source.local.MovieDataSourceLocal
import com.example.movie.data.data_source.remote.MovieDataSourceRemote
import com.example.movie.domain.MovieRepository
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularFailure
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularResponse
import com.example.network.internet_connection.InternetConnectionRepository


/** */
internal class MovieRepositoryImpl(
    private val movieDataSourceRemote: MovieDataSourceRemote,
    private val movieDataSourceLocal: MovieDataSourceLocal,
    internetConnectionRepository: InternetConnectionRepository
) : MovieRepository, InternetConnectionRepository by internetConnectionRepository {


    /** */
    override suspend fun getMoviePopular():
            Either<GetMoviePopularFailure, GetMoviePopularResponse> =
        if (isOnline)
            movieDataSourceRemote.getMoviePopular()
        else movieDataSourceLocal.getMoviePopular()

}