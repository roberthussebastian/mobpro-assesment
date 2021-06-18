package org.robertsiagian.moviecatalogue.di

import android.content.Context
import org.robertsiagian.moviecatalogue.data.source.MoviesRepository
import org.robertsiagian.moviecatalogue.data.source.TvShowRepository
import org.robertsiagian.moviecatalogue.data.source.remote.RemoteDataSource
import org.robertsiagian.moviecatalogue.ui.utils.JsonHelper

object Injection {

    fun provideMoviesRepository(context: Context) : MoviesRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MoviesRepository.getInstance(remoteDataSource)
    }

    fun provideTvShowRepository(context: Context) : TvShowRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return TvShowRepository.getInstance(remoteDataSource)
    }
}