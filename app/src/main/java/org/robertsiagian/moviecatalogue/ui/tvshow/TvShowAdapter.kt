package org.robertsiagian.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.robertsiagian.moviecatalogue.R
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.databinding.ItemsTvshowBinding
import org.robertsiagian.moviecatalogue.ui.detail.tvshow.DetailTvShowActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShow = ArrayList<TvShowsEntity>()

    fun setTvShow(tvShow: List<TvShowsEntity>?) {
        if (tvShow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowsEntity) {
            with(binding) {
                tvshowItemTitle.text = tvShows.showsTitle
                tvshowItemDate.text = itemView.resources.getString(R.string.pubYear_date, tvShows.showsPubYear)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShows.showsId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(tvShows.showsImage)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }
}