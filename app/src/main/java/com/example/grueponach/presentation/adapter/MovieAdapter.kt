package com.example.grueponach.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.movie.domain.entity.MovieResult


/**
 *
 */
class MovieAdapter(
    private val onActionClickListener: (movieResult: MovieResult) -> Unit
) : ListAdapter<MovieResult, MovieViewHolder>(MovieDiffCallback) {

    /**
     *
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder =
        MovieViewHolder.from(parent, onActionClickListener)

    /**
     *
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    /**
     *
     */
    private object MovieDiffCallback : DiffUtil.ItemCallback<MovieResult>() {

        /**
         *
         */
        override fun areItemsTheSame(
            oldItem: MovieResult,
            newItem: MovieResult
        ): Boolean = oldItem.id == newItem.id

        /**
         *
         */
        override fun areContentsTheSame(
            oldItem: MovieResult,
            newItem: MovieResult
        ) = oldItem.equals(newItem)

    }

}