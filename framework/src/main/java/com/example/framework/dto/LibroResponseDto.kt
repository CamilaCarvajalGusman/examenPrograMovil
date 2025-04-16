package com.example.framework.dto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.example.domain.Libro

@JsonClass(generateAdapter = true)
class LibroResponseDto (
    @Json (title="title")
    val title: String,
    @Json (author_name="author_name")
    val author_name:String,
    @Json (first_publish_year="first_publish_year")
    val first_publish_year:Int
){}