package com.micheldev.discovercastilla_lamancha


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

open class InicioPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_page)

        val btnExplorarInicio: Button = findViewById(R.id.btnExplorarInicio)
        btnExplorarInicio.setOnClickListener {
            val intent = Intent(this, authentication::class.java)
            startActivity(intent)
        }

    }

}

