package com.example.data_source.data_source

import com.example.data_source.data_source.remote.http_client.retrofit.RetrofitBuilder
import org.koin.dsl.module.module
import retrofit2.Retrofit

/**
 *
 *
 */
val httpClientModule = module {

    /** RETROFIT **/
    single<Retrofit> {
        RetrofitBuilder(
            serverUrlProvider = get(),

        ).build()
    }


}