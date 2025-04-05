package com.example.productoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.productoapp.model.Producto
import com.example.productoapp.model.ProductoProvider

class ProductoViewModel : ViewModel() {

    // MutableLiveData privada
    private val _productoModel = MutableLiveData<Producto>()

    // LiveData pública de solo lectura
    val productoModel: LiveData<Producto> get() = _productoModel

    fun obtenerProductoAleatorio() {
        val productoAleatorio = ProductoProvider.aleatorio()
        _productoModel.postValue(productoAleatorio)
    }
}