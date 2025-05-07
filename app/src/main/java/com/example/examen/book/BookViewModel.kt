package com.example.examen.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Book
import com.example.usecases.GetBooks
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel (
    private val getBooks: GetBooks
): ViewModel() {

    private val _flow = MutableStateFlow<BookState>(BookState.Init)
    val flow : StateFlow<BookState> get()= _flow

    fun fetchBooks(title:String){
        viewModelScope.launch {
            _flow.value=BookState.Successful(model=getBooks.invoke(title))
        }
    }
    sealed class BookState {
        object Init: BookState()
        class Successful(val model: Book): BookState()
        class Error(val message: String): BookState()
    }
}
