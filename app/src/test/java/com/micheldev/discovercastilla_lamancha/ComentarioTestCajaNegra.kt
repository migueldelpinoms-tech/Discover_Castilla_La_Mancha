package com.micheldev.discovercastilla_lamancha

import org.junit.Assert.assertEquals
import org.junit.Test


class ComentarioTestCajaNegra {
    @Test
    fun crearComentarioConValoresPredeterminados() {
        // Creeo un objeto Comentario usando los valores predeterminados
        val comentario = Comentario()

        // Verificar que los valores iniciales son correctos
        assertEquals("", comentario.usuario)
        assertEquals("", comentario.texto)
        assertEquals("", comentario.fecha)
    }

    @Test
    fun crearComentarioConValoresValidos() {
        // Creo un objeto Comentario con valores válidos
        val comentario = Comentario(
            usuario = "Michael",
            texto = "¡Qué lugar tan hermoso para visitar!",
            fecha = "2023-12-25"
        )

        // Verifico que los valores se asignaron correctamente
        assertEquals("Michael", comentario.usuario)
        assertEquals("¡Qué lugar tan hermoso para visitar!", comentario.texto)
        assertEquals("2023-12-25", comentario.fecha)
    }

    @Test
    fun crearComentarioConCamposVacios() {
        // Creo un objeto Comentario con algunos campos vacíos
        val comentario = Comentario(
            usuario = "",
            texto = "¡Un lugar excelente!",
            fecha = ""
        )

        // Verifico que los valores vacíos se manejan correctamente
        assertEquals("", comentario.usuario)
        assertEquals("¡Un lugar excelente!", comentario.texto)
        assertEquals("", comentario.fecha)
    }
}