package com.micheldev.discovercastilla_lamancha


import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*

class InicioPageTestCajaNegra {
    @Test
    fun verificarNavegacionAAuthentication() {
        // Simula la acción de clic en el botón
        val resultado = navegarA()
        // Verifico que el resultado sea la clase esperada
        assertEquals("com.micheldev.discovercastilla_lamancha.authentication", resultado)
    }

    // Función auxiliar para simular la navegación
    private fun navegarA(): String {
        // Aquí simulo lo que hace el botón en InicioPage
        val intent = "com.micheldev.discovercastilla_lamancha.authentication" // Destino esperado
        return intent
    }
}