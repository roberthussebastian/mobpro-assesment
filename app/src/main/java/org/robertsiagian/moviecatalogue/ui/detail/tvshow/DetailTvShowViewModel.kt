package org.robertsiagian.moviecatalogue.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.data.source.TvShowRepository

class DetailTvShowViewModel (private val tvShowRepository: TvShowRepository) : ViewModel() {

    private lateinit var showsId: String

    fun setSelectedtvSHow(showsId: String) {
        this.showsId = showsId
    }

    fun getTvShow(): LiveData<TvShowsEntity> = tvShowRepository.getTvShowWithDetail(showsId)
}