package com.example.xtrememovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class Search : AppCompatActivity(), OnItemClickListener {
    override fun OnItemClicked(movie: Movie) {
        AppDatabase.getInstance(this).getDao().insertMovie(movie)
        Toast.makeText(applicationContext,"Se agregó " + movie.title + " a favoritos",Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        // Boton regresar
        btnReturn.setOnClickListener {
            finish()
        }
        btnSearch.setOnClickListener {
            searchMovies()
        }
    }
    var movies = ArrayList<Movie>()
    lateinit var movieAdapter: MovieAdapter

    private fun updateList() {
        movieAdapter = MovieAdapter(movies, this)
        rvMovies.adapter = movieAdapter
        rvMovies.layoutManager = LinearLayoutManager(this)
    }

    private fun searchMovies() {
        val tituloBuscar = tieTitle.text.toString()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val movieService: MovieService
        movieService = retrofit.create(MovieService::class.java)
        val request = movieService.searchMovie("3cae426b920b29ed2fb1c0749f258325", tituloBuscar)
        request.enqueue(object : Callback<DataResponse> {
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Log.d("Search", t.toString())
            }

            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful){
                    tvResults.text = "Se encontró " + response.body()!!.total_results.toString() + " coincidencia(s)"
                    movies = response.body()!!.results
                    updateList()
                }
            }
        })
    }
}
