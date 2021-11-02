package com.example.movie.domain.use_case.get_movie_popular

import com.example.domain.Either
import com.example.domain.UseCase
import com.example.movie.domain.MovieRepository


/* */
class GetMoviePopularUseCase(
    private val movieRepository: MovieRepository
) : UseCase<GetMoviePopularResponse, GetMoviePopularParams, GetMoviePopularFailure>() {

    /** */
    override suspend fun run(
        params: GetMoviePopularParams
    ): Either<GetMoviePopularFailure, GetMoviePopularResponse> =
        movieRepository.getMoviePopular()
}