package com.example.ecommerceappexamen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sampleProduct = Product(
            name = "Auriculares Inalámbricos",
            price = 1299.99,
            description = "Auriculares con cancelación de ruido y batería de 24h.",
            category = "Electrónica",
            inStock = true,
            relatedProducts = listOf("Funda", "Cargador", "Estuche rígido")
        )

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ProductDetail(product = sampleProduct)
                }
            }
        }
    }
}

@Composable
fun ProductDetail(product: Product) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = product.name, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Precio: $${product.price} MXN", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Categoría: ${product.category}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = product.description, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = if (product.inStock) "Disponible" else "Agotado",
            color = if (product.inStock) Color.Green else Color.Red,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Productos relacionados:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        if (product.relatedProducts.isNotEmpty()) {
            LazyColumn {
                items(product.relatedProducts) { related ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = related,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        } else {
            Text(text = "Sin productos relacionados", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
