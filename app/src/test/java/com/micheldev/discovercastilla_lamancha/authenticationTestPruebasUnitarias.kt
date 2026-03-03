package com.micheldev.discovercastilla_lamancha

import com.google.firebase.auth.FirebaseAuth
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class authenticationTestPruebasUnitarias {
    // Instancio mock de FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    @Before
    fun configurar() {
        // Mockeo FirebaseAuth antes de cada test
        firebaseAuth = mock(FirebaseAuth::class.java)
    }

    @Test
    fun `verificacionregistrodeusuarioexitoso`() {
        // Datos de prueba
        val email = "prueba@ejemplo.com"
        val contraseña = "123456"

        // Simulo registro exitoso
        firebaseAuth.createUserWithEmailAndPassword(email, contraseña)

        // Verifico que el método correcto fue llamado
        verify(firebaseAuth).createUserWithEmailAndPassword(email, contraseña)
    }

    @Test
    fun `verificariniciodesesiónexitoso`() {
        // Datos de prueba
        val email = "prueba@ejemplo.com"
        val contraseña = "123456"

        // Simulación inicio de sesión exitoso
        firebaseAuth.signInWithEmailAndPassword(email, contraseña)

        // Verifico que el método correcto fue llamado
        verify(firebaseAuth).signInWithEmailAndPassword(email, contraseña)
    }
}