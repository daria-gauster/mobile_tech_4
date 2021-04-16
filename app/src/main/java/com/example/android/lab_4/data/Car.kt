package com.example.android.lab_4.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_table")
data class Car(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    var model: String,
    var year: String,
    var imageURI: String?
)