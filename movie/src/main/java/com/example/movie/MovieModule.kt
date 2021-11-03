package com.example.movie

import com.example.data_source.data_source.remote.http_client.retrofit.RetrofitBuilder
import com.example.movie.data.MovieDataSource
import com.example.movie.data.MovieRepositoryImpl
import com.example.movie.data.data_source.local.MovieDataBase
import com.example.movie.data.data_source.local.MovieDataSourceLocal
import com.example.movie.data.data_source.remote.MovieApiServices
import com.example.movie.data.data_source.remote.MovieDataSourceRemote
import com.example.movie.domain.MovieRepository
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularUseCase
import com.example.movie.presentation.get_movie_popular.GetMoviePopular
import com.example.movie.presentation.get_movie_popular.GetMoviePopularImpl
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val movieModule: Module = module {

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

    single {
        MovieDataSourceRemote(
            movieDao = get(),
            movieApiServices = get()
        )
    }
    single {
        MovieDataSourceLocal(
            movieDao = get()
        )
    }


    /** ROOM **/
    single { MovieDataBase.getInstance(get()) }
    /**DAO**/
    single { get<MovieDataBase>().movieDao() }

    /** API SERVICE **/
    single<MovieApiServices> {
        RetrofitBuilder(
            serverUrlProvider = get()
        ).build().create(MovieApiServices::class.java)
    }
}