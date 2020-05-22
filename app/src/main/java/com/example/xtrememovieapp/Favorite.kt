package com.example.xtrememovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_favorite.*

class Favorite : AppCompatActivity(), OnItemClickListener {

    override fun OnItemClicked(movie: Movie) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        // Boton regresar
        btnReturn.setOnClickListener {
            finish()
        }
        loadFavorite()
    }

    lateinit var movies: List<Movie>
    lateinit var movieAdapter: MovieAdapter

    private fun loadFavorite() {
        movies = AppDatabase.getInstance(this).getDao().getAll()
        movieAdapter = MovieAdapter(movies, this)
        rvFavorite.adapter = movieAdapter
        rvFavorite.layoutManager = LinearLayoutManager(this)
    }




}
