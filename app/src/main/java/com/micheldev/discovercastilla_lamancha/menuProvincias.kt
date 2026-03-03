package com.micheldev.discovercastilla_lamancha

import android.view.Menu
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.micheldev.discovercastilla_lamancha.Provincias.Albacete
import com.micheldev.discovercastilla_lamancha.Provincias.CiudadReal
import com.micheldev.discovercastilla_lamancha.Provincias.Cuenca
import com.micheldev.discovercastilla_lamancha.Provincias.Guadalajara
import com.micheldev.discovercastilla_lamancha.Provincias.Toledo

class menuProvincias : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_provincias)

        // Configuración de los botones
        val btnToledo: Button = findViewById(R.id.btnToledo)
        btnToledo.setOnClickListener {
            val intent = Intent(this, Toledo::class.java)
            startActivity(intent)
        }

        val btnCiudadReal: Button = findViewById(R.id.btnCiudadReal)
        btnCiudadReal.setOnClickListener {
            val intent = Intent(this, CiudadReal::class.java)
            startActivity(intent)
        }

        val btnGuadalajara: Button = findViewById(R.id.btnGuadalajara)
        btnGuadalajara.setOnClickListener {
            val intent = Intent(this, Guadalajara::class.java)
            startActivity(intent)
        }

        val btnCuenca: Button = findViewById(R.id.btnCuenca)
        btnCuenca.setOnClickListener {
            val intent = Intent(this, Cuenca::class.java)
            startActivity(intent)
        }

        val btnAlbacete: Button = findViewById(R.id.btnAlbacete)
        btnAlbacete.setOnClickListener {
            val intent = Intent(this, Albacete::class.java)
            startActivity(intent)
        }
    }

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
