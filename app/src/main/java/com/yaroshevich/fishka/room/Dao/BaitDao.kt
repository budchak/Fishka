package com.yaroshevich.fishka.room.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yaroshevich.fishka.room.entities.BaitEntity


@Dao
interface BaitDao {

    @Query("SELECT * FROM bait")
    fun getAll(): List<BaitEntity>

    @Query("SELECT * FROM bait WHERE id = :id")
    fun getById(id: Int): BaitEntity

    @Insert
    fun insert(panel: BaitEntity)

    @Update
    fun update(panel: BaitEntity)

    @Delete
    fun delete(panel: BaitEntity)
}