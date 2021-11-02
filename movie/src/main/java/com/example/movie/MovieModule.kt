package com.example.movie

import com.example.movie.data.MovieDataSource
import com.example.movie.data.MovieRepositoryImpl
import com.example.movie.data.data_source.local.MovieDataBase
import com.example.movie.data.data_source.local.MovieDataSourceLocal
import com.example.movie.domain.MovieRepository
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularUseCase
import com.example.movie.presentation.get_movie_popular.GetMoviePopular
import com.example.movie.presentation.get_movie_popular.GetMoviePopularImpl
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val movieModule : Module = module  {

    /** PRESENTATION **/
    single<GetMoviePopular> { GetMoviePopularImpl(getMoviePopularUseCase = get()) }

    /** USE CASE **/
    factory { GetMoviePopularUseCase(movieRepository = get()) }

    /** REPOSITORY **/
    single<MovieRepository> {
        MovieRepositoryImpl(
            movieDataSourceLocal = get(),
            movieDataSourceRemote = get(),
            internetConnectionRepository = get()
        )
    }


    /** DATA SOURCE **/
    single<MovieDataSource> { MovieDataSourceLocal(movieDao = get()) }


    /** ROOM **/
    single { MovieDataBase.getInstance(get()) }
    /**DAO**/
    single { get<MovieDataBase>().movieDao() }
}