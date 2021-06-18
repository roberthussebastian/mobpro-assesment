package org.robertsiagian.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Test
import org.junit.Assert.*
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.mockito.Mockito
import org.robertsiagian.moviecatalogue.data.source.remote.RemoteDataSource
import org.robertsiagian.moviecatalogue.ui.utils.DataDummy
import org.robertsiagian.moviecatalogue.ui.utils.LiveDataTestUtil

class MoviesRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val moviesRepository = FakeMoviesRepository(remote)

    private val moviesResponses =  DataDummy.generateRemoteDummyMovies()
    private val moviesId = moviesResponses[0].moviesId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(moviesResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val moviesEntities = LiveDataTestUtil.getValue(moviesRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(moviesEntities)
        assertEquals(moviesResponses.size.toLong(), moviesEntities.size.toLong())
    }

    @Test
    fun getMoviesWithDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(moviesResponses)
            null
        }.`when`(remote).getAllMovies(any())

        val resultCode = LiveDataTestUtil.getValue(moviesRepository.getMoviesWithDetail(moviesId))
        verify<RemoteDataSource>(remote).getAllMovies(any())
        assertNotNull(resultCode)
        assertEquals(moviesResponses[0].titles, resultCode.titles)
    }
}