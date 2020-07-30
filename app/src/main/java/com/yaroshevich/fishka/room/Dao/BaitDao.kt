package com.yaroshevich.fishka.room.Dao

import androidx.room.*
import com.yaroshevich.fishka.room.entities.BaitEntity


@Dao
interface BaitDao {

    @Query("SELECT * FROM bait")
    suspend fun getAll(): List<BaitEntity>

    @Query("SELECT * FROM bait WHERE id = :id")
    suspend fun getById(id: Int): BaitEntity

    @Insert
    suspend fun insert(panel: BaitEntity)

    @Update
    suspend fun update(panel: BaitEntity)

    @Delete
    suspend fun delete(panel: BaitEntity)
}