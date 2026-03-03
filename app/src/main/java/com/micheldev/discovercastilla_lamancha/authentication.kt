package com.micheldev.discovercastilla_lamancha


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class authentication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authentication)

    //setup (establecer)
        setur()
    //setupAuthentication (establecer)
        setupAuthentication()
    }

    private fun setur() {
        title = "Autentificación"
        // Para acceder al botón de registro
        //Obtengo los valores del email y contraseña de los campos de texto
        val emailAddress = findViewById<EditText>(R.id.emailAddress)
        val textPassword = findViewById<EditText>(R.id.textPassword)
        //Configuro un OnClickListener para el botón de registro
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        }

    private fun setupAuthentication() {
        title = "Autentificación"

        // Para acceder al botón de registro
        //Obtengo los valores del email y contraseña de los campos de texto
        val emailAddress = findViewById<EditText>(R.id.emailAddress)
        val textPassword = findViewById<EditText>(R.id.textPassword)
        //Configuro un OnClickListener para el botón de registro
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        // Verifico que los campos de email y contraseña no estén vacíos
        signUpButton.setOnClickListener {
            if (emailAddress.text.isNotEmpty() && textPassword.text.isNotEmpty()) {
                // Llamo al método createUserWithEmailAndPassword para registrar al usuario en Firebase
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailAddress.text.toString(), textPassword.text.toString())
                    .addOnCompleteListener { task ->
                        // Si la creación del usuario es exitosa, inicia la próxima actividad
                        if (task.isSuccessful) {
                            Toast.makeText(baseContext,"Registro realizado correctamente.", Toast.LENGTH_SHORT).show()
                            // Autenticación exitosa, inicia la próxima actividad
                           /* val intent = Intent(this, HomePage::class.java)
                            startActivity(intent)
                            finish() // Finaliza la actividad actual si es necesario */
                        } else {
                            // Manejo del error
                            Toast.makeText(baseContext, "Autentificación fallida.", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(baseContext, "Por favor, rellene ambos campos.", Toast.LENGTH_SHORT).show()
            }
        }

        // Para acceder al botón de inicio de sesión
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Verifico que los campos de email y contraseña no estén vacíos
        loginButton.setOnClickListener {
            if (emailAddress.text.isNotEmpty() && textPassword.text.isNotEmpty()) {
                // Llamo al método signInWithEmailAndPassword para iniciar sesión en Firebase
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailAddress.text.toString(), textPassword.text.toString())
                    .addOnCompleteListener { task ->
                        // Si el inicio de sesión es exitoso, inicia la próxima actividad
                        if (task.isSuccessful) {
                            // Inicio de sesión exitoso, inicia la próxima actividad
                            val intent = Intent(this, menuProvincias::class.java)
                            startActivity(intent)
                            finish() // Finaliza la actividad actual si es necesario
                        } else {
                            // Manejo del error
                            Toast.makeText(baseContext, "Inicio de sesión fallido.", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(baseContext, "Por favor, rellene ambos campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }


}