package com.example.grueponach.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grueponach.databinding.MovieViewHolderBinding
import com.example.grueponach.presentation.common.setBannerMovie
import com.example.movie.domain.entity.MovieResult

class MovieViewHolder(
    private val binding: MovieViewHolderBinding,
    private val onFileStudentClickListener: (fileStudent: MovieResult) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    /**
     *
     */
    fun bind(movieResult: MovieResult) {
        binding.apply {
            setBannerMovie(ivBanner, movieResult.posterPath)
            tvTitleMovie.text = movieResult.title
            tvOverviewMovie.text = movieResult.overview
            tvVoteAverage.text = movieResult.voteAverage.toString()
        }

        binding.root.setOnClickListener { onFileStudentClickListener(movieResult) }

    }

    /** */
    companion object {

        /** */
        fun from(
            parent: ViewGroup,
            onFileStudentClickListener: (fileStudent: MovieResult) -> Unit
        ): MovieViewHolder {
            val binding = MovieViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return MovieViewHolder(binding, onFileStudentClickListener)
        }

    }

}