package com.example.data_source.data_source.remote.http_client

/**
 *
 */
interface HeaderInterceptor {

    /**
     *
     */
    fun getAuthorizationType() : String

    /**
     *
     */
    fun getAuthorizationValue() : String

}
