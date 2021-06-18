package org.robertsiagian.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity
import org.robertsiagian.moviecatalogue.data.source.remote.RemoteDataSource
import org.robertsiagian.moviecatalogue.data.source.remote.response.MoviesResponse

class MoviesRepository private constructor(private val remoteDataSource: RemoteDataSource) : MoviesDataSource {

    companion object {
        @Volatile
        private var instance: MoviesRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MoviesRepository =
                instance ?: synchronized(this) {
                    instance ?: MoviesRepository(remoteData).apply {
                        instance = this
                    }
                }
    }

    override fun getAllMovies(): LiveData<List<MoviesEntity>> {
        val moviesResults = MutableLiveData<List<MoviesEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponse: List<MoviesResponse>) {
                val moviesList = ArrayList<MoviesEntity>()
                for (response in moviesResponse) {
                    val movies = MoviesEntity(response.moviesId,
                            response.titles,
                            response.description,
                            response.pubYear,
                            response.imagePath)
                    moviesList.add(movies)
                }
                moviesResults.postValue(moviesList)
            }
        })

        return moviesResults
    }

    override fun getMoviesWithDetail(moviesId: String): LiveData<MoviesEntity> {

        val moviesResult = MutableLiveData<MoviesEntity>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponse: List<MoviesResponse>) {
                lateinit var movies: MoviesEntity
                for (response in moviesResponse) {
                    if (response.moviesId == moviesId) {
                        movies = MoviesEntity(response.moviesId,
                                response.titles,
                                response.description,
                                response.pubYear,
                                response.imagePath)
                    }
                }
                moviesResult.postValue(movies)
            }
        })
        return moviesResult
    }
}