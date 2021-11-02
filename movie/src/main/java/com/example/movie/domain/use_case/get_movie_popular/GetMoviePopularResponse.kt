package com.example.movie.domain.use_case.get_movie_popular

import com.example.movie.domain.entity.MovieResult


/* */
data class GetMoviePopularResponse(
    val movieResult: List<MovieResult>
)
