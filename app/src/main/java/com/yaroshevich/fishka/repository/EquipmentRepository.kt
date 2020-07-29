package com.yaroshevich.fishka.repository

interface EquipmentRepository<Entity> {

    suspend fun getAll(): List<Entity>
    suspend fun getAll(id: Int): List<Entity>
    suspend fun getBy(id: Int): Entity

    suspend fun create(entity: Entity)
    suspend fun update(entity: Entity)
    suspend fun delete(entity: Entity)
}