package org.robertsiagian.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.data.source.TvShowRepository

class TvShowViewModel (private val tvShowRepository: TvShowRepository) : ViewModel() {

    fun getTvShow() : LiveData<List<TvShowsEntity>> = tvShowRepository.getAllTvShow()
}