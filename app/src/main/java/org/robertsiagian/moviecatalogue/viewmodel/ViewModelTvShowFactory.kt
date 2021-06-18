package org.robertsiagian.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.robertsiagian.moviecatalogue.data.source.TvShowRepository
import org.robertsiagian.moviecatalogue.di.Injection
import org.robertsiagian.moviecatalogue.ui.detail.tvshow.DetailTvShowViewModel
import org.robertsiagian.moviecatalogue.ui.tvshow.TvShowViewModel

class ViewModelTvShowFactory private constructor(private val mTvShowRepository: TvShowRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance : ViewModelTvShowFactory? = null

        fun getInstance(context: Context) : ViewModelTvShowFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelTvShowFactory(Injection.provideTvShowRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mTvShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(mTvShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}