package com.yaroshevich.fishka.room.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yaroshevich.fishka.room.entities.LineEntity


@Dao
interface LineDao {

    @Query("SELECT * FROM line")
    fun getAll():List<LineEntity>

    @Query("SELECT * FROM line WHERE id = :id")
    fun getById(id: Int): LineEntity

    @Insert
    fun insert(panel: LineEntity)

    @Update
    fun update(panel: LineEntity)

    @Delete
    fun delete(panel: LineEntity)
}