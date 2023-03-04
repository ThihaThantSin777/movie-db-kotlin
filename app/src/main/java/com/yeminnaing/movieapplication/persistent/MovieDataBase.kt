package com.yeminnaing.movieapplication.persistent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.persistent.dao.MovieDAO
import com.yeminnaing.movieapplication.utils.MOVIE_DB

@Database(entities = [MovieVO::class], version = 1, exportSchema = false)
abstract class MovieDataBase : RoomDatabase() {
    companion object {
        const val DB_NAME = MOVIE_DB;
        var dbInstance: MovieDataBase? = null;

        fun getDBInstance(context: Context): MovieDataBase? {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MovieDataBase::class.java, DB_NAME)
                        .allowMainThreadQueries().fallbackToDestructiveMigration().build()
                }
            }
            return  dbInstance;
        }
    }
    abstract  fun movieDAO():MovieDAO;
}