package com.example.grueponach.di

import com.example.data_source.data_source.httpClientModule
import com.example.grueponach.NachApplication
import com.example.grueponach.di.shared_module.serverUrlProvider
import com.example.movie.movieModule
import com.example.network.networkModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

/**
 * Initialize the Koin instance with the modules associated to the project.
 */
fun NachApplication.initKoin() {
    val sharedModules = getSharedModules()
    val featureModules = getFeatureModules()
    val presentationModules = getPresentationModules()
    val modules = sharedModules + featureModules + presentationModules
    startKoin(applicationContext, modules)
}

/**
 *
 */
private fun getSharedModules(): List<Module> = listOf(
    /** NETWORK **/
    networkModule,
    /** DATA SOURCE **/
    httpClientModule,
    serverUrlProvider,
)

/** */
private fun getFeatureModules(): List<Module> = listOf( movieModule
)

/**
 *
 */
private fun getPresentationModules(): List<Module> = listOf(
)
