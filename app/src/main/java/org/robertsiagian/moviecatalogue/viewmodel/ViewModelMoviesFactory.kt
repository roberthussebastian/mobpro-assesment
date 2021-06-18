package org.robertsiagian.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.robertsiagian.moviecatalogue.data.source.MoviesRepository
import org.robertsiagian.moviecatalogue.di.Injection
import org.robertsiagian.moviecatalogue.ui.detail.movies.DetailMoviesViewModel
import org.robertsiagian.moviecatalogue.ui.movies.MoviesViewModel

class ViewModelMoviesFactory private constructor(private val mMoviesRepository: MoviesRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance : ViewModelMoviesFactory? = null

        fun getInstance(context: Context) : ViewModelMoviesFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelMoviesFactory(Injection.provideMoviesRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(DetailMoviesViewModel::class.java) -> {
                return DetailMoviesViewModel(mMoviesRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}