package com.micheldev.discovercastilla_lamancha.Provincias

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.micheldev.discovercastilla_lamancha.ForoActivity
import com.micheldev.discovercastilla_lamancha.R
import com.micheldev.discovercastilla_lamancha.authentication

class Albacete : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_albacete)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Acceder al botón de información.
        val btnInfoA = findViewById<ImageButton>(R.id.btnInfoA)

        // Configurar el OnClickListener para el botón
        btnInfoA.setOnClickListener {
            // URL que deseas abrir
            val url =
                "https://repositorio.turismocastillalamancha.com/miscelanea/178546/14/97a8/folleto-albacete-pdf.pdf?d=1"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de patrimonio.
        val btnPatrimonioA = findViewById<ImageButton>(R.id.btnPatrimonioA)

        // Configurar el OnClickListener para el botón
        btnPatrimonioA.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/patrimonio/albacete/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de artesania.
        val btnArtesaniaA = findViewById<ImageButton>(R.id.btnArtesaniaA)

        // Configurar el OnClickListener para el botón
        btnArtesaniaA.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/artesania/albacete/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de fiestas.
        val btnFiestasA = findViewById<ImageButton>(R.id.btnFiestasA)

        // Configurar el OnClickListener para el botón
        btnFiestasA.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/fiestas/albacete/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de gastronomía.
        val btnGastronomiaA = findViewById<ImageButton>(R.id.btnGastronomiaA)

        // Configurar el OnClickListener para el botón
        btnGastronomiaA.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/gastronomia/albacete/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de naturaleza.
        val btnNaturalezaA = findViewById<ImageButton>(R.id.btnNaturalezaA)

        // Configurar el OnClickListener para el botón
        btnNaturalezaA.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/naturaleza/albacete/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    //Implemento el menú desplegable.
    // Inflar el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.items, menu)
        return true
    }

    // Manejar los ítems del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.desplegableT -> {
                val intent = Intent(this, Toledo::class.java)
                startActivity(intent)
                true
            }
            R.id.desplegableCR -> {
                val intent = Intent(this, CiudadReal::class.java)
                startActivity(intent)
                true
            }
            R.id.desplegableG -> {
                val intent = Intent(this, Guadalajara::class.java)
                startActivity(intent)
                true
            }
            R.id.desplegableC -> {
                val intent = Intent(this, Cuenca::class.java)
                startActivity(intent)
                true
            }
            R.id.desplegableA -> {
                val intent = Intent(this, Albacete::class.java)
                startActivity(intent)
                true
            }
            R.id.desplegableForo -> {
                val intent = Intent(this, ForoActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.desplegableCierreSesion -> {
                cerrarSesion()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }
    private fun cerrarSesion() {
        // Cierra la sesión de Firebase
        FirebaseAuth.getInstance().signOut()

        // Redirige al usuario a la pantalla de inicio de sesión
        val intent = Intent(this, authentication::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish() // Cierra la actividad actual
    }
}