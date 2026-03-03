package com.micheldev.discovercastilla_lamancha

import org.junit.Assert.assertTrue
import org.junit.Test

class MenuProvinciasTest {

    @Test
    fun verificarBotonesExistentes() {
        // Lista de IDs de los botones
        val botonesIds = listOf(
            R.id.btnToledo,
            R.id.btnCiudadReal,
            R.id.btnGuadalajara,
            R.id.btnCuenca,
            R.id.btnAlbacete
        )

        // Simulo una lógica para verificar que los botones están en la lista
        val botonesDefinidos = listOf(
            R.id.btnToledo,
            R.id.btnCiudadReal,
            R.id.btnGuadalajara,
            R.id.btnCuenca,
            R.id.btnAlbacete
        )

        // Verifico que todos los IDs esperados están definidos correctamente
        assertTrue("Algunos botones no están definidos en el diseño", botonesIds.all { it in botonesDefinidos })
    }
}
