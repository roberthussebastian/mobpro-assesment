package org.robertsiagian.moviecatalogue.ui.detail.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.databinding.ItemsTvshowBinding

class DetailTvShowAdapter : RecyclerView.Adapter<DetailTvShowAdapter.DetailTvShowViewHolder>() {

    private val listDetail = ArrayList<TvShowsEntity>()

    fun setDetailTvShow(details: TvShowsEntity) {
        if (details == null) return
        this.listDetail.clear()
        this.listDetail.addAll(listOf(details))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailTvShowViewHolder {
        val itemsTvShowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailTvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(viewHolder: DetailTvShowViewHolder, position: Int) {
        val details = listDetail[position]
        viewHolder.bind(details)
    }

    override fun getItemCount(): Int = listDetail.size

    inner class DetailTvShowViewHolder(private val binding: ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detail: TvShowsEntity) {
            binding.tvshowItemTitle.text = detail.showsDescription
        }
    }
}