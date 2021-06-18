package org.robertsiagian.moviecatalogue.ui.detail.movies

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
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity
import org.robertsiagian.moviecatalogue.data.source.MoviesRepository
import org.robertsiagian.moviecatalogue.ui.utils.DataDummy

@RunWith(MockitoJUnitRunner::class)
class DetailMoviesViewModelTest {

    private lateinit var viewModel: DetailMoviesViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val moviesId = dummyMovies.moviesId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Mock
    private lateinit var moviesObserver: Observer<MoviesEntity>


    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel(moviesRepository)
        viewModel.setSelectedMovies(moviesId)
    }

    @Test
    fun getMovies() {
        val movies = MutableLiveData<MoviesEntity>()
        movies.value = dummyMovies

        `when`(moviesRepository.getMoviesWithDetail(moviesId)).thenReturn(movies)
        val moviesEntity = viewModel.getMovies().value as MoviesEntity
        verify(moviesRepository).getMoviesWithDetail(moviesId)
        assertNotNull(moviesEntity)
        assertEquals(dummyMovies.moviesId, moviesEntity.moviesId)
        assertEquals(dummyMovies.pubYear, moviesEntity.pubYear)
        assertEquals(dummyMovies.description, moviesEntity.description)
        assertEquals(dummyMovies.imagePath, moviesEntity.imagePath)
        assertEquals(dummyMovies.titles, moviesEntity.titles)

        viewModel.getMovies().observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyMovies)

    }
}