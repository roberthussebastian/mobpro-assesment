package org.robertsiagian.moviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity
import org.robertsiagian.moviecatalogue.data.source.MoviesRepository

class MoviesViewModel (private val moviesRepository: MoviesRepository) : ViewModel() {

    fun getMovies() : LiveData<List<MoviesEntity>> = moviesRepository.getAllMovies()
}