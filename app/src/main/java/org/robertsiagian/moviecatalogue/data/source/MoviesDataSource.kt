package org.robertsiagian.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity

interface MoviesDataSource {

    fun getAllMovies() : LiveData<List<MoviesEntity>>

    fun getMoviesWithDetail(moviesId : String) : LiveData<MoviesEntity>
}