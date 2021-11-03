package com.example.grueponach.presentation.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.Failure
import com.example.domain.presentation.Status
import com.example.grueponach.databinding.MovieFragmentBinding
import com.example.grueponach.presentation.adapter.MovieAdapter
import com.example.grueponach.presentation.common.extension.gone
import com.example.grueponach.presentation.common.extension.showSnackbar
import com.example.grueponach.presentation.common.extension.visible
import com.example.grueponach.presentation.common.failure_manage.getCommonFailureMessage
import com.example.movie.domain.entity.MovieResult
import com.example.movie.presentation.get_movie_popular.MoviePopularStatus
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {
    /* */
    private val binding: MovieFragmentBinding by lazy {
        MovieFragmentBinding.inflate(layoutInflater)
    }

    /* */
    private val moviesViewModel: MoviesViewModel by viewModel()

    private lateinit var movieAdapter: MovieAdapter

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        execute()
    }

    private fun setupView() {
        intRecyclerView()
    }

    /** */
    private fun intRecyclerView() {
        movieAdapter = MovieAdapter(::onMovieClickListener)
        binding.rvMovie.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = movieAdapter
        }

    }

    /** */
    private fun onMovieClickListener(movieResult: MovieResult) {
        showSnackbar(movieResult.title)
    }

    /** */
    private fun execute() {
        moviesViewModel.getMoviePopularAsLiveData()
            .observe(viewLifecycleOwner, createGetMoviePopularStatusObserver())
    }

    /**
     *
     */
    private fun createGetMoviePopularStatusObserver() = Observer<MoviePopularStatus> {
        binding.progressCircular.gone()
        when (it) {
            is Status.Loading -> binding.progressCircular.visible()
            is Status.Failed -> manageGetMoviePopularFailure(it.failure)
            is Status.Done -> manageGetMoviePopularDone(it.value.movieResult)
        }
    }


    /** */
    private fun manageGetMoviePopularDone(movieResult: List<MovieResult>) {
        movieAdapter.submitList(movieResult)
    }

    /** */
    private fun manageGetMoviePopularFailure(failure: Failure) {
        val message = getCommonFailureMessage(failure)
        showSnackbar(message)
    }
}