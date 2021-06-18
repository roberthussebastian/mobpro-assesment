package org.robertsiagian.moviecatalogue.ui.detail.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity
import org.robertsiagian.moviecatalogue.data.source.MoviesRepository

class DetailMoviesViewModel (private val moviesRepository: MoviesRepository) : ViewModel() {

    private lateinit var moviesId: String

    fun setSelectedMovies(moviesId: String) {
        this.moviesId = moviesId
    }

    fun getMovies(): LiveData<MoviesEntity> = moviesRepository.getMoviesWithDetail(moviesId)
}