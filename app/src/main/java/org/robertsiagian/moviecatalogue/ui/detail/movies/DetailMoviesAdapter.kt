package org.robertsiagian.moviecatalogue.ui.detail.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity
import org.robertsiagian.moviecatalogue.databinding.ItemsMoviesBinding

class DetailMoviesAdapter : RecyclerView.Adapter<DetailMoviesAdapter.DetailViewHolder>() {

    private val listDetail = ArrayList<MoviesEntity>()

    fun setDetailMovies(details: MoviesEntity) {
        if (details == null) return
        this.listDetail.clear()
        this.listDetail.addAll(listOf(details))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val itemMoviesBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(itemMoviesBinding)
    }

    override fun onBindViewHolder(viewHolder: DetailViewHolder, position: Int) {
        val detail = listDetail[position]
        viewHolder.bind(detail)
    }

    override fun getItemCount(): Int = listDetail.size

    inner class DetailViewHolder(private val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detail: MoviesEntity) {
            binding.moviesItemTitle.text = detail.description
        }
    }
}