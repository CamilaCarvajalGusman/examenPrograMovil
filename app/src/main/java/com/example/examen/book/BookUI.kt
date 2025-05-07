package com.example.examen.book

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.domain.Book
import com.example.examen.R

@Composable
fun BookUI(viewModel: BookViewModel = hiltViewModel()) {
    var query by remember { mutableStateOf("") }
    val bookState by viewModel.flow.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = query,
                onValueChange = { query = it },
                label = { Text("Ingrese el título del libro") }
            )
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.fetchBooks(query) }
            ) {
                Text("Buscar libro")
            }

            when (val state = bookState) {
                is BookViewModel.BookState.Init -> {
                    Text("Ingrese el título de un libro para buscar")
                }
                is BookViewModel.BookState.Successful -> {
                    Text(state.model.title) // Mostrar el título del libro
                }
                is BookViewModel.BookState.Error -> {
                    Text("Error: No se encontró el libro.")
                }
            }
        }
    }
}