package org.robertsiagian.moviecatalogue.ui.utils

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import org.robertsiagian.moviecatalogue.data.source.remote.response.MoviesResponse
import org.robertsiagian.moviecatalogue.data.source.remote.response.TvShowResponse
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFIleToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies() : List<MoviesResponse> {
        val listMovies = ArrayList<MoviesResponse>()
        try {
            val responseMoviesObject = JSONObject(parsingFIleToString("MoviesResponses.json").toString())
            val listArrayMovies = responseMoviesObject.getJSONArray("movies")
            for (i in 0 until listArrayMovies.length()) {
                val movies = listArrayMovies.getJSONObject(i)

                val moviesId = movies.getString("moviesId")
                val titles = movies.getString("titles")
                val description = movies.getString("description")
                val pubYear = movies.getString("pubYear")
                val imagePath = movies.getString("imagePath")

                val moviesResponse = MoviesResponse(moviesId,titles,description, pubYear, imagePath)
                listMovies.add(moviesResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return listMovies
    }

    fun loadTvShow() : List<TvShowResponse> {
        val listTvShow = ArrayList<TvShowResponse>()
        try {
            val responseTvShowObject = JSONObject(parsingFIleToString("TvShowResponses.json").toString())
            val listArrayTvShow = responseTvShowObject.getJSONArray("tvShows")
            for (i in 0 until listArrayTvShow.length()) {
                val tvShows = listArrayTvShow.getJSONObject(i)

                val showsId = tvShows.getString("showsId")
                val showsTitle = tvShows.getString("showsTitle")
                val showsDescription = tvShows.getString("showsDescription")
                val showsPubYear = tvShows.getString("showsPubYear")
                val showsImage = tvShows.getString("showsImage")

                val tvShowResponse = TvShowResponse(showsId, showsTitle, showsDescription, showsPubYear, showsImage)
                listTvShow.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return listTvShow
    }
}