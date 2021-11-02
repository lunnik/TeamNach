package com.example.movie.presentation.get_movie_popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.domain.Either
import com.example.domain.onLeft
import com.example.domain.onRight
import com.example.domain.presentation.Status
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularFailure
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularParams
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularResponse
import com.example.movie.domain.use_case.get_movie_popular.GetMoviePopularUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class GetMoviePopularImpl(
    private val getMoviePopularUseCase: GetMoviePopularUseCase
) : GetMoviePopular {

    /* */
    override lateinit var getMoviePopularFailure: GetMoviePopularFailure

    /* */
    override lateinit var getMoviePopularResponse: GetMoviePopularResponse

    /** */
    override fun getMoviePopularAsLiveData(params: GetMoviePopularParams):
            LiveData<MoviePopularStatus> = flow<MoviePopularStatus> {
        emit(Status.Loading())
        getMoviePopularAsEither(params)
            .onLeft { emit(Status.Failed(it)) }
            .onRight { emit(Status.Done(it)) }
    }.asLiveData(Dispatchers.IO)

    /** */
    override suspend fun getMoviePopularAsEither(params: GetMoviePopularParams):
            Either<GetMoviePopularFailure, GetMoviePopularResponse> =
        getMoviePopularUseCase.run(params)
            .onLeft { getMoviePopularFailure = it }
            .onRight { getMoviePopularResponse = it }
}