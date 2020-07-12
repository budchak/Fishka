package com.yaroshevich.fishka.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "reel")
class ReelEntity(@PrimaryKey(autoGenerate = true)var id: Int = 0, var brand: String, var model: String, var size: String)