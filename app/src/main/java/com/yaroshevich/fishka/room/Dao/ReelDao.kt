package com.yaroshevich.fishka.room.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yaroshevich.fishka.room.entities.ReelEntity
import com.yaroshevich.fishka.room.entities.RodEntity

@Dao
interface ReelDao {

    @Query("SELECT * FROM reel")
    fun getAll(): List<ReelEntity>

    @Query("SELECT * FROM reel WHERE id = :id")
    fun getById(id: Int): ReelEntity

    @Insert
    fun insert(panel: ReelEntity)

    @Update
    fun update(panel: ReelEntity)

    @Delete
    fun delete(panel: ReelEntity)
}