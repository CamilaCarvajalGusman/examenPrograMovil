package com.example.framework.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass (generateAdapter = true)
class BookResponseDto (
    @Json(name="title")
    val title:String,
    @Json (name="author_name")
    val authors:String,
    @Json (name="first_publish_year")
    val publish_year:Int){

}