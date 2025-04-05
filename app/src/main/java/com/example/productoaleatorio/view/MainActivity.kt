package com.example.productoapp.view
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer // Corrección en el import
import com.example.productoapp.databinding.ActivityMainBinding // Binding generado
import com.example.productoapp.viewmodel.ProductoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observar el LiveData expuesto del ViewModel
        viewModel.productoModel.observe(this, Observer { producto ->
            binding.tvProducto.text = "Producto: ${producto.nombre}\nPrecio: $${producto.precio}"
        })

        // Acción al hacer clic en la vista raíz
        binding.root.setOnClickListener {
            viewModel.obtenerProductoAleatorio()
        }
    }
}