package com.yaroshevich.fishka.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "line")
class LineEntity(@PrimaryKey(autoGenerate = true)var id: Int = 0, var brand: String, var size: Int) {
}