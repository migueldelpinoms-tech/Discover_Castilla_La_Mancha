package com.micheldev.discovercastilla_lamancha
import org.junit.Assert.assertEquals
import org.junit.Test


class authenticationTestCajaNegra{
    @Test
    fun cuandoCamposEstanVacios_mostrarMensajeDeError() {
        // Simulo un escenario en el que los campos están vacíos
        val email = ""
        val password = ""

        val resultado = validarCampos(email, password)
        assertEquals("Por favor, rellene ambos campos.", resultado)
    }

    @Test
    fun cuandoCamposNoEstanVacios_intentaRegistro() {
        // Simulo un escenario en el que los campos están llenos
        val email = "usuario@example.com"
        val password = "123456"

        val resultado = validarCampos(email, password)
        assertEquals("Intentar registro", resultado)
    }

    fun validarCampos(email: String, password: String): String {
        return if (email.isEmpty() || password.isEmpty()) {
            "Por favor, rellene ambos campos."
        } else {
            "Intentar registro"
        }
    }

}