package com.example.network
import com.example.network.internet_connection.InternetConnectionRepositoryImpl
import com.example.network.internet_connection.InternetConnectionRepository
import org.koin.dsl.module.module

/* */
val networkModule = module {

    /* Internet connection repository instance */
    single<InternetConnectionRepository>(createOnStart = true) {
        InternetConnectionRepositoryImpl()
    }

}
