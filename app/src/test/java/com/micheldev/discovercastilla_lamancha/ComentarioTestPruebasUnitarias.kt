package com.micheldev.discovercastilla_lamancha

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test


class ComentarioTestPruebasUnitarias {
    @Test
    fun testInicializacionComentario() {
        // Creo un objeto Comentario con valores por defecto
        val comentario = Comentario()

        // Verifico que los valores iniciales sean correctos
        assertEquals("", comentario.usuario)
        assertEquals("", comentario.texto)
        assertEquals("", comentario.fecha)
    }

    @Test
    fun testMetodoCopy() {
        // Creo un objeto Comentario
        val comentarioOriginal = Comentario("Usuario1", "Este es un comentario", "20/03/2025")

        // Creo una copia con un campo modificado
        val comentarioCopia = comentarioOriginal.copy(texto = "Nuevo comentario")

        // Verifico que la copia se haya cambiado solo en el campo especificado
        assertEquals("Usuario1", comentarioCopia.usuario)
        assertEquals("Nuevo comentario", comentarioCopia.texto)
        assertEquals("20/03/2025", comentarioCopia.fecha)

        // Verifico que el original no haya cambiado
        assertEquals("Este es un comentario", comentarioOriginal.texto)
    }

    @Test
    fun testIgualdadObjetos() {
        // Creo dos objetos iguales
        val comentario1 = Comentario("Usuario1", "Texto igual", "20/03/2025")
        val comentario2 = Comentario("Usuario1", "Texto igual", "20/03/2025")

        // Verifico que sean considerados iguales
        assertEquals(comentario1, comentario2)

        // Creo un objeto diferente
        val comentarioDiferente = Comentario("Usuario2", "Otro texto", "21/03/2025")

        // Verifico que no sean iguales
        assertNotEquals(comentario1, comentarioDiferente)
    }
}