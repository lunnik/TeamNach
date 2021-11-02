package com.example.movie.data.data_source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movie.data.data_source.local.dao.MovieDao
import com.example.movie.domain.entity.MovieResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@Database(
    entities = [MovieResult::class],
    version = 1,
    exportSchema = false
)
 internal abstract class MovieDataBase : RoomDatabase() {

    /** */
    abstract fun movieDao(): MovieDao

    /** */
    companion object {
        /* */
        private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        /* */

        /** */
        fun getInstance(context: Context): MovieDataBase {
            synchronized(MovieDataBase::class.java) {
                return Room.databaseBuilder(
                    context.applicationContext,
                    MovieDataBase::class.java, DB_NAME
                ).fallbackToDestructiveMigration()
                    .build()
            }

        }

        /* */
        private const val DB_NAME = "movie.db"
    }

}