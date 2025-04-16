package com.example.examen.libro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Libro
import com.example.usecases.FindLibro
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch

@HiltViewModel
class LibroViewModel @Inject constructor(
    val findGitAlias : FindLibro
) : ViewModel() {
    val findLibro = FindLibro()



    sealed class LibroState {
        object Init: LibroState()
        class Successful(val model: Libro): LibroState()
    }
    private val _flow = MutableStateFlow<LibroState>(LibroState.Init)


    val flow : StateFlow<LibroState> = _flow

    fun fetchLibro(title: String) {
        viewModelScope.launch {
            findLibro.invoke(title) // esta llamada retorna un Objeto del modulo domain
        }
    }
}
