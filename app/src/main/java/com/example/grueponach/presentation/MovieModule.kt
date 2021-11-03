package com.example.grueponach.presentation

import com.example.grueponach.presentation.movie.MoviesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val movieModulePresentation :Module = module {

    /* */
    viewModel {
        MoviesViewModel(getMoviePopular = get())
    }
}