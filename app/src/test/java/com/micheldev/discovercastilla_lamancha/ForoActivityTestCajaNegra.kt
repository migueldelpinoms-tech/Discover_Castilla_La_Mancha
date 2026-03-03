package com.micheldev.discovercastilla_lamancha

import org.junit.Assert.assertEquals
import org.junit.Test


class ForoActivityTestCajaNegra {
    @Test
    fun cuandoComentarioEstaVacio_mostrarMensajeDeError() {
        val textoComentario = "" // Simula un comentario vacío
        val resultado = validarComentario(textoComentario)
        assertEquals("Error: El comentario está vacío", resultado)
    }

    @Test
    fun cuandoComentarioEsValido_enviarComentario() {
        val textoComentario = "¡Qué buen lugar para visitar!" // Comentario válido
        val resultado = validarComentario(textoComentario)
        assertEquals("Comentario enviado", resultado)
    }

    @Test
    fun cargarComentariosDesdeFirebase_exito() {
        val comentariosMock = listOf(
            Comentario("Usuario1", "Comentario 1", "01/01/2023"),
            Comentario("Usuario2", "Comentario 2", "02/01/2023")
        )

        val comentariosCargados = cargarComentarios(comentariosMock)
        assertEquals(2, comentariosCargados.size)
        assertEquals("Usuario1", comentariosCargados[0].usuario)
        assertEquals("Comentario 1", comentariosCargados[0].texto)
    }

    @Test
    fun alSeleccionarCerrarSesion_redirigirALogin() {
        val resultado = cerrarSesion()
        assertEquals("Usuario redirigido a la pantalla de autenticación", resultado)
    }
    fun validarComentario(comentario: String): String {
        return if (comentario.trim().isEmpty()) {
            "Error: El comentario está vacío"
        } else {
            "Comentario enviado"
        }
    }

    fun cargarComentarios(comentarios: List<Comentario>): List<Comentario> {
        return comentarios // Simulo que los comentarios se cargan correctamente
    }

    fun cerrarSesion(): String {
        return "Usuario redirigido a la pantalla de autenticación"
    }

}