package org.robertsiagian.moviecatalogue.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.data.source.TvShowRepository
import org.robertsiagian.moviecatalogue.ui.utils.DataDummy

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val showsId = dummyTvShow.showsId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: TvShowRepository

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowsEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(tvShowRepository)
        viewModel.setSelectedtvSHow(showsId)
    }

    @Test
    fun getTvShow() {
        val tvShows = MutableLiveData<TvShowsEntity>()
        tvShows.value = dummyTvShow

        Mockito.`when`(tvShowRepository.getTvShowWithDetail(showsId)).thenReturn(tvShows)
        val tvShowEntity = viewModel.getTvShow().value as TvShowsEntity
        verify(tvShowRepository).getTvShowWithDetail(showsId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.showsId, tvShowEntity.showsId)
        assertEquals(dummyTvShow.showsPubYear, tvShowEntity.showsPubYear)
        assertEquals(dummyTvShow.showsDescription, tvShowEntity.showsDescription)
        assertEquals(dummyTvShow.showsImage, tvShowEntity.showsImage)
        assertEquals(dummyTvShow.showsTitle, tvShowEntity.showsTitle)

        viewModel.getTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)

    }
}