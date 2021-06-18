package org.robertsiagian.moviecatalogue.ui.detail.movies

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.robertsiagian.moviecatalogue.R
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity
import org.robertsiagian.moviecatalogue.databinding.ActivityDetailMoviesBinding
import org.robertsiagian.moviecatalogue.databinding.ContentDetailMoviesBinding
import org.robertsiagian.moviecatalogue.viewmodel.ViewModelMoviesFactory

class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailMoviesBinding: ContentDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        detailMoviesBinding = activityDetailMoviesBinding.detailContentMovies

        activityDetailMoviesBinding.fab.setOnClickListener{
            shareData()
        }
        setContentView(activityDetailMoviesBinding.root)

        setSupportActionBar(activityDetailMoviesBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailMoviesAdapter()

        val factory = ViewModelMoviesFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailMoviesViewModel::class.java]

        val extrasMovies = intent.extras
        if (extrasMovies != null) {
            val moviesId = extrasMovies.getString(EXTRA_MOVIE)
            if (moviesId != null) {

                activityDetailMoviesBinding.progressBar.visibility = View.VISIBLE

                viewModel.setSelectedMovies(moviesId)
                viewModel.getMovies().observe(this, { details ->
                    activityDetailMoviesBinding.progressBar.visibility = View.GONE
                    adapter.setDetailMovies(details)
                    adapter.notifyDataSetChanged()
                })
                viewModel.getMovies().observe(this, { course -> populateMovies(course) })
            }
        }

    }
    private fun populateMovies(moviesEntity: MoviesEntity) {
        detailMoviesBinding.textTitle.text = moviesEntity.titles
        detailMoviesBinding.textDescription.text = moviesEntity.description
        detailMoviesBinding.textDate.text = resources.getString(R.string.pubYear_date, moviesEntity.pubYear)

        Glide.with(this)
                .load(moviesEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailMoviesBinding.imagePoster)
    }

    private fun shareData() {
        val pesan = getString(R.string.template_bagikan)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, pesan)
        startActivity(shareIntent)
        }
    }

