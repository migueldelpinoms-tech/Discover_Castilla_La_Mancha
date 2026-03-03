package com.micheldev.discovercastilla_lamancha.Provincias

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import com.google.firebase.auth.FirebaseAuth
import com.micheldev.discovercastilla_lamancha.ForoActivity
import com.micheldev.discovercastilla_lamancha.R
import com.micheldev.discovercastilla_lamancha.authentication

class Toledo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toledo)

        // Acceder al botón de guía.
        val btnInfoT = findViewById<ImageButton>(R.id.btnInfoT)

        // Configurar el OnClickListener para el botón
        btnInfoT.setOnClickListener {
            // URL que deseas abrir
            val url =
                "https://repositorio.turismocastillalamancha.com/miscelanea/178551/14/7571/folleto-toledo-pdf.pdf?d=1"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de patrimonio.
        val btnPatrimonioT = findViewById<ImageButton>(R.id.btnPatrimonioT)

        // Configurar el OnClickListener para el botón
        btnPatrimonioT.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/patrimonio/toledo/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de artesania.
        val btnArtesaniaT = findViewById<ImageButton>(R.id.btnArtesaniaT)

        // Configurar el OnClickListener para el botón
        btnArtesaniaT.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/artesania/toledo/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de fiestas.
        val btnFiestasT = findViewById<ImageButton>(R.id.btnFiestasT)

        // Configurar el OnClickListener para el botón
        btnFiestasT.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/fiestas/toledo/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de gastronomía.
        val btnGastronomiaT = findViewById<ImageButton>(R.id.btnGastronomiaT)

        // Configurar el OnClickListener para el botón
        btnGastronomiaT.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/gastronomia/toledo/"

            // Crear un Intent para abrir el navegador web
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Acceder al botón de naturaleza.
        val btnNaturalezaT = findViewById<ImageButton>(R.id.btnNaturalezaT)

        // Configurar el OnClickListener para el botón
        btnNaturalezaT.setOnClickListener {
            // URL que deseas abrir
            val url = "https://www.turismocastillalamancha.es/naturaleza/toledo/"

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