package com.example.xtrememovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Boton buscar
        btnSearch.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }
        // Boton favoritos
        btnFavorite.setOnClickListener {
            val intent = Intent(this, Favorite::class.java)
            startActivity(intent)
        }
    }
}
