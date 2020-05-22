package com.example.xtrememovieapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Query("select * from Movie")
    fun getAll(): List<Movie>

    @Insert
    fun insertMovie(vararg movie: Movie)

    @Delete
    fun deleteMovie(vararg movie: Movie)
}