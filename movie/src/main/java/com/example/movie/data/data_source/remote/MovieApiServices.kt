package com.example.movie.data.data_source.remote

import com.example.movie.data.data_source.remote.model.GetMovieHttpResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieApiServices {

    /** */
    @GET(URL.GET_STUDENT_PROFILE)
    suspend fun getMoviePopular(
        @Query("api_key") apiKey: String
    ): Response<GetMovieHttpResponse>

    /** */
    private object URL {
        /* */
        const val GET_STUDENT_PROFILE: String = "movie/popular/"

    }
}