package org.robertsiagian.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import org.robertsiagian.moviecatalogue.data.source.remote.response.MoviesResponse
import org.robertsiagian.moviecatalogue.data.source.remote.response.TvShowResponse
import org.robertsiagian.moviecatalogue.ui.utils.EspressoIdlingResource
import org.robertsiagian.moviecatalogue.ui.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }
    }

    fun getAllMovies(callback : LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllTvShow(callback : LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvShowReceived(jsonHelper.loadTvShow())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(moviesResponse: List<MoviesResponse>)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>)
    }
}