package com.example.framework.mappers

import com.example.domain.Book
import com.example.framework.dto.BookResponseDto

fun BookResponseDto.toModel(): Book {
    return Book(
        title =  title,
        authors = authors,
        publishYear=publish_year
    )
}