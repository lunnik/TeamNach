package com.example.movie.domain.entity


class Movie(
    val page: Int,
    val results: List<MovieResult>,
    val totalPages: Int,
    val totalResults: Int
)