package com.micheldev.discovercastilla_lamancha


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.micheldev.discovercastilla_lamancha.Provincias.Albacete
import com.micheldev.discovercastilla_lamancha.Provincias.CiudadReal
import com.micheldev.discovercastilla_lamancha.Provincias.Cuenca
import com.micheldev.discovercastilla_lamancha.Provincias.Guadalajara
import com.micheldev.discovercastilla_lamancha.Provincias.Toledo
import java.text.SimpleDateFormat
import java.util.*

class ForoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var comentarioAdapter: ComentarioAdapter
    private lateinit var editTextComentario: EditText
    private lateinit var buttonEnviar: Button
    private lateinit var foroRef: DatabaseReference

    private val listaComentarios = mutableListOf<Comentario>()

    val fechaActual: String
        get() {
            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            return sdf.format(Date())
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.foro)

        recyclerView = findViewById(R.id.recyclerViewComentarios)
        editTextComentario = findViewById(R.id.editTextComentario)
        buttonEnviar = findViewById(R.id.buttonEnviar)

        comentarioAdapter = ComentarioAdapter(listaComentarios)
        recyclerView.adapter = comentarioAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val database = FirebaseDatabase.getInstance()
        foroRef = database.getReference("foro/comentarios")

        buttonEnviar.setOnClickListener {
            val textoComentario = editTextComentario.text.toString()
            val nombreUsuario = "Anónimo"
            if (textoComentario.trim().isNotEmpty()) {
                val nuevoComentario = Comentario(nombreUsuario, textoComentario.trim(), fechaActual)
                foroRef.push().setValue(nuevoComentario).addOnCompleteListener {
                    editTextComentario.text.clear()
                }.addOnFailureListener {
                    Toast.makeText(this, "Error al enviar comentario", Toast.LENGTH_SHORT).show()
                }
            }
        }

        cargarComentariosDesdeFirebase()
    }

    private fun cargarComentariosDesdeFirebase() {
        foroRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                listaComentarios.clear()
                for (comentarioSnapshot in snapshot.children) {
                    val comentario = comentarioSnapshot.getValue(Comentario::class.java)
                    if (comentario != null) {
                        listaComentarios.add(comentario)
                    }
                }
                comentarioAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ForoActivity, "Error al cargar los comentarios", Toast.LENGTH_SHORT).show()
                error.toException().printStackTrace()
            }
        })
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

class ComentarioAdapter(private val comentarios: List<Comentario>) : RecyclerView.Adapter<ComentarioAdapter.ComentarioViewHolder>() {

    class ComentarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUsuario: TextView = itemView.findViewById(R.id.textViewUsuario)
        val textViewFecha: TextView = itemView.findViewById(R.id.textViewFecha)
        val textViewComentario: TextView = itemView.findViewById(R.id.textViewComentario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComentarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comentario, parent, false)
        return ComentarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComentarioViewHolder, position: Int) {
        val comentario = comentarios[position]
        holder.textViewUsuario.text = comentario.usuario
        holder.textViewFecha.text = comentario.fecha
        holder.textViewComentario.text = comentario.texto
    }

    override fun getItemCount(): Int = comentarios.size


}
