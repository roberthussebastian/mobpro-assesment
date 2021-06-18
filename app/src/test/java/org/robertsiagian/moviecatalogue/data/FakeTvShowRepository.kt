package org.robertsiagian.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.robertsiagian.moviecatalogue.data.source.TvShowDataSource
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.data.source.remote.RemoteDataSource
import org.robertsiagian.moviecatalogue.data.source.remote.response.TvShowResponse

class FakeTvShowRepository (private val remoteDataSource: RemoteDataSource) : TvShowDataSource {

    override fun getAllTvShow(): LiveData<List<TvShowsEntity>> {
        val tvShowResults = MutableLiveData<List<TvShowsEntity>>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowsEntity>()
                for (response in tvShowResponse) {
                    val tvShows = TvShowsEntity(response.showsId,
                        response.showsTitle,
                        response.showsDescription,
                        response.showsPubYear,
                        response.showsImage)
                    tvShowList.add(tvShows)
                }
                tvShowResults.postValue(tvShowList)
            }
        })
        return tvShowResults
    }

    override fun getTvShowWithDetail(showsId: String): LiveData<TvShowsEntity> {

        val tvShowResult = MutableLiveData<TvShowsEntity>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                lateinit var tvShows: TvShowsEntity
                for (response in tvShowResponse) {
                    if (response.showsId == showsId) {
                        tvShows = TvShowsEntity(response.showsId,
                            response.showsTitle,
                            response.showsDescription,
                            response.showsPubYear,
                            response.showsImage)
                    }
                }
                tvShowResult.postValue(tvShows)
            }
        })
        return tvShowResult
    }
}