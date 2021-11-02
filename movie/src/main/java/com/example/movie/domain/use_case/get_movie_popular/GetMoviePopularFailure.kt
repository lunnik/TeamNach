package com.example.movie.domain.use_case.get_movie_popular

import com.example.data_source.data_source.remote.model.failure.HttpFailure
import com.example.domain.Failure


/* */
sealed class GetMoviePopularFailure : Failure() {

    /** */
    object NetworkConnectionFailure : GetMoviePopularFailure()

    /** */
    object UserDisabled : GetMoviePopularFailure()

    /** */
    object UserTimeOut : GetMoviePopularFailure()

    /** */

    /**
     *
     */
    data class ServerFailure(
        override val code: Int,
        override val message: String
    ) : GetMoviePopularFailure(), HttpFailure

    /** */
    data class UnknownFailure(
        val message: String
    ) : GetMoviePopularFailure()

}