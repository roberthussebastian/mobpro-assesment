package org.robertsiagian.moviecatalogue.ui.detail.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.robertsiagian.moviecatalogue.R
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.databinding.ActivityDetailTvshowsBinding
import org.robertsiagian.moviecatalogue.databinding.ContentDetailTvshowsBinding
import org.robertsiagian.moviecatalogue.viewmodel.ViewModelTvShowFactory

class DetailTvShowActivity: AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var detailTvShowsBinding: ContentDetailTvshowsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvShowsBinding = ActivityDetailTvshowsBinding.inflate(layoutInflater)
        detailTvShowsBinding = activityDetailTvShowsBinding.detailContentTvshow

        activityDetailTvShowsBinding.fab.setOnClickListener{
            shareData()
        }

        setContentView(activityDetailTvShowsBinding.root)

        setSupportActionBar(activityDetailTvShowsBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailTvShowAdapter()

        val factory = ViewModelTvShowFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extrasTvShow = intent.extras
        if (extrasTvShow != null) {
            val showsId = extrasTvShow.getString(EXTRA_TVSHOW)
            if (showsId != null) {
                activityDetailTvShowsBinding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedtvSHow(showsId)
                viewModel.getTvShow().observe(this, { details ->
                    activityDetailTvShowsBinding.progressBar.visibility = View.GONE
                    adapter.setDetailTvShow(details)
                    adapter.notifyDataSetChanged()
                })
                viewModel.getTvShow().observe(this, { course -> populateTvShow(course) })
            }
        }
    }

    private fun populateTvShow(tvShowEntity: TvShowsEntity) {
        detailTvShowsBinding.textTitleShows.text = tvShowEntity.showsTitle
        detailTvShowsBinding.textDescription.text = tvShowEntity.showsDescription
        detailTvShowsBinding.textDate.text = resources.getString(R.string.pubYear_date, tvShowEntity.showsPubYear)

        Glide.with(this)
                .load(tvShowEntity.showsImage)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailTvShowsBinding.imagePoster)

    }

    private fun shareData() {
        val pesan = getString(R.string.template_bagikan)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, pesan)
        startActivity(shareIntent)
    }
}