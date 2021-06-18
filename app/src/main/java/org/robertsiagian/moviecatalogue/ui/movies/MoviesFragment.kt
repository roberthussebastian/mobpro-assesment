package org.robertsiagian.moviecatalogue.ui.movies

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.robertsiagian.moviecatalogue.R
import org.robertsiagian.moviecatalogue.databinding.FragmentMoviesBinding
import org.robertsiagian.moviecatalogue.viewmodel.ViewModelMoviesFactory

class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)

        setHasOptionsMenu(true)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelMoviesFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val moviesAdapter = MoviesAdapter()
            fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovies().observe(viewLifecycleOwner, { courses ->
                fragmentMoviesBinding.progressBar.visibility = View.GONE
                moviesAdapter.setMovies(courses)
                moviesAdapter.notifyDataSetChanged()
            })

            with(fragmentMoviesBinding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }
}