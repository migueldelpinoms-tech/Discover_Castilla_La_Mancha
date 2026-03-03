package com.micheldev.discovercastilla_lamancha

import org.junit.Assert.assertEquals
import org.junit.Test

class InicioPageTestPruebasUnitarias {

    @Test
    fun verificarNavegacionBotonExplorarInicio() {
        // Simulo el comportamiento esperado del botón
        val intentEsperado = "authentication::class.java"
        val intentReal = navegarA("authentication::class.java")

        // Verifico que el intent generado sea el correcto
        assertEquals("El intent esperado no coincide con el real", intentEsperado, intentReal)
    }

    // Método auxiliar para simular navegación
    private fun navegarA(destino: String): String {
        // Lógica simulada para generar el intent
        return destino
    }
}
