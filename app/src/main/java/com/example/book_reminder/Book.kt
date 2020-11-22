package com.example.book_reminder

import androidx.room.Entity
/*
 Entity-umożliwia zapisywanie danych do bazy danych SQLLite
 */
@Entity(tableName = "book",primaryKeys = ["title","author"])

data class Book (

        var title: String,
        var author: String,
        var date: String,
        var rating: Float
)
