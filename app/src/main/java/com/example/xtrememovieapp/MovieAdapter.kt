package com.example.xtrememovieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_movie.view.*

class MovieAdapter(val movies: List<Movie>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<MoviePrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_movie, parent, false)
        return MoviePrototype(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(moviePrototype: MoviePrototype, position: Int) {
        moviePrototype.bind(movies.get(position), itemClickListener)
    }

}

class MoviePrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvTitle = itemView.tvTitle
    val tvOverview = itemView.tvOverview
    val cvMovies = itemView.cvMovies

    fun bind(movie: Movie, itemClickListener: OnItemClickListener){
        tvTitle.text = movie.title
        tvOverview.text = movie.overview
        cvMovies.setOnClickListener {
            itemClickListener.OnItemClicked(movie)
        }
    }

}

interface OnItemClickListener{
    fun OnItemClicked(movie: Movie)
}