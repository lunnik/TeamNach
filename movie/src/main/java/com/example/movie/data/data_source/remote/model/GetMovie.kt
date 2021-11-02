package com.example.movie.data.data_source.remote.model


import com.example.movie.data.data_source.remote.model.dto.ResultDto
import com.example.movie.domain.entity.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class GetMovieHttpResponse(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val results: List<ResultDto>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
) {

    fun toMovie() = Movie(
        page = page,
        results = results.map { it.toResult() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}