package com.example.movie.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie.domain.entity.MovieResult

@Dao
internal interface MovieDao {

    /** */
    @Query("SELECT * FROM MovieResult")
     fun getMoviePopular(): List<MovieResult>

    /** */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createMovieResult(movieResults: MovieResult)
}