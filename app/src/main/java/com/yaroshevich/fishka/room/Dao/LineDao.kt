package com.yaroshevich.fishka.room.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yaroshevich.fishka.room.entities.LineEntity


@Dao
interface LineDao {

    @Query("SELECT * FROM line")
    suspend fun getAll():List<LineEntity>

    @Query("SELECT * FROM line WHERE id = :id")
    suspend  fun getById(id: Int): LineEntity

    @Insert
    suspend fun insert(panel: LineEntity)

    @Update
    suspend  fun update(panel: LineEntity)

    @Delete
    suspend  fun delete(panel: LineEntity)
}