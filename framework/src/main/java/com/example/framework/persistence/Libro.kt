package com.example.framework.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libro")
data class Book(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "author_name")
    var authorName: String,

    @ColumnInfo(name = "first_publish_year")
    var firstPublishYear: Int
)