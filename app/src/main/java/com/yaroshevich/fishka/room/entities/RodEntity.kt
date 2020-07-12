package com.yaroshevich.fishka.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RodEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var brand: String,
    var model: String,
    var length: String,
    var minTest: Int,
    var maxTest: Int
)