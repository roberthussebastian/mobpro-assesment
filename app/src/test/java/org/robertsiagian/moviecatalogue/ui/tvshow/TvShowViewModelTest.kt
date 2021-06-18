package org.robertsiagian.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.data.source.TvShowRepository
import org.robertsiagian.moviecatalogue.ui.utils.DataDummy

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository : TvShowRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowsEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(tvShowRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataDummy.generateDummyTvShows()
        val tvShows = MutableLiveData<List<TvShowsEntity>>()
        tvShows.value = dummyTvShow

        `when`(tvShowRepository.getAllTvShow()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShow().value
        verify(tvShowRepository).getAllTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}