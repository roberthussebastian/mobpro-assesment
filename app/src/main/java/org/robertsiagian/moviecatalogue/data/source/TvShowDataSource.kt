package org.robertsiagian.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity

interface TvShowDataSource {

    fun getAllTvShow() : LiveData<List<TvShowsEntity>>

    fun getTvShowWithDetail(showsId: String) : LiveData<TvShowsEntity>
}