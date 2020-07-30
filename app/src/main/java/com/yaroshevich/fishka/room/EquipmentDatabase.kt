package com.yaroshevich.fishka.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yaroshevich.fishka.room.Dao.BaitDao
import com.yaroshevich.fishka.room.Dao.LineDao
import com.yaroshevich.fishka.room.Dao.ReelDao
import com.yaroshevich.fishka.room.Dao.RodDao
import com.yaroshevich.fishka.room.entities.BaitEntity
import com.yaroshevich.fishka.room.entities.LineEntity
import com.yaroshevich.fishka.room.entities.ReelEntity
import com.yaroshevich.fishka.room.entities.RodEntity

@Database(
    entities = [RodEntity::class, ReelEntity::class, LineEntity::class, BaitEntity::class],
    version = 1
)
abstract class EquipmentDatabase : RoomDatabase() {
    abstract fun rodDao(): RodDao
    abstract fun reelDao(): ReelDao
    abstract fun lineDao(): LineDao
    abstract fun baitDao(): BaitDao

}