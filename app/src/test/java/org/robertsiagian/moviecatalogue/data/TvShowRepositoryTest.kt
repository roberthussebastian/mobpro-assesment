package org.robertsiagian.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.robertsiagian.moviecatalogue.data.source.remote.RemoteDataSource
import org.robertsiagian.moviecatalogue.ui.utils.DataDummy
import org.robertsiagian.moviecatalogue.ui.utils.LiveDataTestUtil

class TvShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val tvShowRepository = FakeTvShowRepository(remote)

    private val tvShowResponses =  DataDummy.generateRemoteDummyTvShows()
    private val showsId = tvShowResponses[0].showsId

    @Test
    fun getAllTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponses)
            null
        }.`when`(remote).getAllTvShow(any())
        val tvShowEntities = LiveDataTestUtil.getValue(tvShowRepository.getAllTvShow())
        verify(remote).getAllTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getTvShowWithDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponses)
            null
        }.`when`(remote).getAllTvShow(any())

        val resultCode = LiveDataTestUtil.getValue(tvShowRepository.getTvShowWithDetail(showsId))
        verify(remote).getAllTvShow(any())
        assertNotNull(resultCode)
        assertEquals(tvShowResponses[0].showsTitle, resultCode.showsTitle)
    }
}