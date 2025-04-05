package com.example.productoapp.model

class ProductoProvider {
    companion object {
        private val productoList = listOf(
            Producto("Celular",900.000 ),
            Producto("Reloj", 500.000),
            Producto("Anillo", 700.000)
        )

        fun aleatorio(): Producto {
            return productoList.random()
        }
    }
}