package org.robertsiagian.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity

@Dao
interface TvShowsDao {

    @Insert
    suspend fun insert(tvShows : TvShowsEntity)

    @Query("SELECT * FROM tvShows")
    fun getTvShows() : LiveData<TvShowsEntity?>
}