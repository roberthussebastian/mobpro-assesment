package org.robertsiagian.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity

@Dao
interface MoviesDao {

    @Insert
    suspend fun insert(movies: MoviesEntity)


    @Query("SELECT * FROM movies")
    fun getMovies() : LiveData<MoviesEntity?>

}