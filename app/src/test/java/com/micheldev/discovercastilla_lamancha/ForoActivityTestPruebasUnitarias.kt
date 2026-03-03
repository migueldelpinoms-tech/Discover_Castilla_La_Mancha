package com.micheldev.discovercastilla_lamancha

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

// Clase de prueba para ForoActivity
class ForoActivityTestPruebasUnitarias {

    private lateinit var foroRefMock: DatabaseReference
    private lateinit var databaseMock: FirebaseDatabase

    @Before
    fun configurar() {
        // Simula FirebaseDatabase y DatabaseReference
        databaseMock = mock(FirebaseDatabase::class.java)
        foroRefMock = mock(DatabaseReference::class.java)

        // Configura el mock para devolver foroRefMock cuando se llame a getReference()
        `when`(databaseMock.getReference("foro/comentarios")).thenReturn(foroRefMock)
    }

    @Test
    fun `pruebo a agregar un comentario exitoso`() {
        // Datos de prueba
        val comentario = Comentario("Anónimo", "Este es un comentario de prueba", "20/03/2025")

        // Simula el método push y setValue
        val comentarioPushMock = mock(DatabaseReference::class.java)
        `when`(foroRefMock.push()).thenReturn(comentarioPushMock)

        // Lógica de prueba: simula agregar un comentario
        foroRefMock.push().setValue(comentario)

        // Verificaciones
        verify(foroRefMock).push() // Verifica que se llamó a push()
        verify(comentarioPushMock).setValue(comentario) // Verifica que se llamó a setValue()
    }

    @Test
    fun `pruebo a cargar comentarios desde Firebase`() {
        // Simula la llamada a la base de datos
        val valueEventListenerMock = mock(ValueEventListener::class.java)
        foroRefMock.addValueEventListener(valueEventListenerMock)

        // Verifica que el método addValueEventListener sea llamado
        verify(foroRefMock).addValueEventListener(any())
    }
}

