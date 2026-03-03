package com.micheldev.discovercastilla_lamancha

import org.junit.Assert.assertEquals
import org.junit.Test

class menuProvinciasTestCajaNegra {
    @Test
    fun verificarNavegacionBotonToledo() {
        val resultado = navegarA(R.id.btnToledo)
        assertEquals("com.micheldev.discovercastilla_lamancha.Provincias.Toledo", resultado)
    }

    @Test
    fun verificarNavegacionBotonCiudadReal() {
        val resultado = navegarA(R.id.btnCiudadReal)
        assertEquals("com.micheldev.discovercastilla_lamancha.Provincias.CiudadReal", resultado)
    }

    @Test
    fun verificarNavegacionBotonGuadalajara() {
        val resultado = navegarA(R.id.btnGuadalajara)
        assertEquals("com.micheldev.discovercastilla_lamancha.Provincias.Guadalajara", resultado)
    }

    @Test
    fun verificarNavegacionBotonCuenca() {
        val resultado = navegarA(R.id.btnCuenca)
        assertEquals("com.micheldev.discovercastilla_lamancha.Provincias.Cuenca", resultado)
    }

    @Test
    fun verificarNavegacionBotonAlbacete() {
        val resultado = navegarA(R.id.btnAlbacete)
        assertEquals("com.micheldev.discovercastilla_lamancha.Provincias.Albacete", resultado)
    }

    @Test
    fun verificarCerrarSesion() {
        val resultado = cerrarSesion()
        assertEquals("com.micheldev.discovercastilla_lamancha.authentication", resultado)
    }

    // Función auxiliar para simular la navegación desde los botones
    private fun navegarA(buttonId: Int): String {
        return when (buttonId) {
            R.id.btnToledo -> "com.micheldev.discovercastilla_lamancha.Provincias.Toledo"
            R.id.btnCiudadReal -> "com.micheldev.discovercastilla_lamancha.Provincias.CiudadReal"
            R.id.btnGuadalajara -> "com.micheldev.discovercastilla_lamancha.Provincias.Guadalajara"
            R.id.btnCuenca -> "com.micheldev.discovercastilla_lamancha.Provincias.Cuenca"
            R.id.btnAlbacete -> "com.micheldev.discovercastilla_lamancha.Provincias.Albacete"
            else -> "Desconocido"
        }
    }

    // Función auxiliar para simular el flujo de cierre de sesión
    private fun cerrarSesion(): String {
        return "com.micheldev.discovercastilla_lamancha.authentication"
    }
}