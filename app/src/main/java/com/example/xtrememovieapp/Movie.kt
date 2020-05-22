package com.example.xtrememovieapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie (
    @PrimaryKey()
    var id: Int?,
    @ColumnInfo(name="title")
    var title: String?,
    @ColumnInfo(name="overview")
    var overview: String?
)