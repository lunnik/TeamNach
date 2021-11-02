package com.example.grueponach.di.shared_module

import com.example.data_source.domain.ServerUrlProvider
import com.example.grueponach.BuildConfig
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/* */
val serverUrlProvider: Module = module {

    single {
        ServerUrlProvider(BuildConfig.API_BASE_URL)
    }

}