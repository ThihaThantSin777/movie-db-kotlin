package com.yeminnaing.movieapplication.persistent.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.utils.MOVIE_ENTITY_NAME

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movieList: List<MovieVO>);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleMovies(movie: MovieVO?);

    @Query(value = "SELECT * FROM $MOVIE_ENTITY_NAME")
    fun getAllMovies(): List<MovieVO>


    @Query(value = "DELETE FROM $MOVIE_ENTITY_NAME")
    fun deleteAllMovies()

    @Query(value = "SELECT * FROM $MOVIE_ENTITY_NAME WHERE id = :movieID")
    fun getMovieByID(movieID: Int): MovieVO?;

    @Query(value = "SELECT * FROM $MOVIE_ENTITY_NAME WHERE type = :type")
    fun getMovieByType(type: String): List<MovieVO>
}