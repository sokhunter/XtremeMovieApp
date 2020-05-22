package com.example.xtrememovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_favorite.*

class Favorite : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        // Boton regresar
        btnReturn.setOnClickListener {
            finish()
        }
    }
}
