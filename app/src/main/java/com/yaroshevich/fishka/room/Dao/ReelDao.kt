package com.yaroshevich.fishka.room.Dao

import androidx.room.*
import com.yaroshevich.fishka.room.entities.ReelEntity

@Dao
interface ReelDao {

    @Query("SELECT * FROM reel")
    suspend fun getAll(): List<ReelEntity>

    @Query("SELECT * FROM reel WHERE id = :id")
    suspend fun getById(id: Int): ReelEntity

    @Insert
    suspend fun insert(panel: ReelEntity)

    @Update
    suspend fun update(panel: ReelEntity)

    @Delete
    suspend fun delete(panel: ReelEntity)
}