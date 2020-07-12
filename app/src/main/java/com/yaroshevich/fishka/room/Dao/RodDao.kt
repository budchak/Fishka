package com.yaroshevich.fishka.room.Dao

import androidx.room.*
import com.yaroshevich.fishka.room.entities.RodEntity


@Dao
interface RodDao {

    @Query("SELECT * FROM rodentity")
    suspend fun getAll(): List<RodEntity>

    @Query("SELECT * FROM rodentity WHERE id = :rodID")
    suspend fun getById(rodID: Int): RodEntity

    @Insert
    suspend  fun insert(panel: RodEntity)

    @Update
    fun update(panel: RodEntity)

    @Delete
    fun delete(panel: RodEntity)
}