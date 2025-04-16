package com.example.examen.libro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.Libro
import com.example.examen.R


@Composable
fun LibroUI() {
    var title by remember { mutableStateOf("") }
    val viewModel : LibroViewModel = viewModel()
    val libroState by viewModel.flow.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column( horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = {
                    title = it
                },
                label = {
                    Text(stringResource(id = R.string.libro_input))
                }
            )
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel().fetchLibro(title)

                }
            ) {
                Text(stringResource(id = R.string.libro_btn_find))
            }
            when( libroState) {
                is LibroViewModel.LibroState.Init -> {
                    Text("Not content yet")
                }
                is LibroViewModel.LibroState.Successful -> {
                    Text("${(LibroViewModel.LibroState as LibroViewModel.LibroState.Successful).model.login}")

                }            }

        }
    }
}

fun viewModel(): Any {

}
