package com.example.framework.mappers

import com.example.domain.Libro
import com.example.framework.dto.LibroResponseDto


fun LibroResponseDto.toModel(): Libro {
    return return Libro(
        title = title,
        author_name = author_name,
        first_publish_year=first_publish_year
    )
}
