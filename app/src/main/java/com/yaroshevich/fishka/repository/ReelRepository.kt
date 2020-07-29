package com.yaroshevich.fishka.repository

import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.model.Reel
import com.yaroshevich.fishka.room.entities.ReelEntity
import com.yaroshevich.fishka.util.ListTypeConverter

class ReelRepository: EquipmentRepository<Reel> {

    val reelDao = App.getInstance().database.reelDao()

   override suspend fun getAll(): List<Reel>{
        val dataBaseResult = reelDao.getAll()

        return ReelMapper().convert(dataBaseResult)
    }

    override suspend fun create(reel: Reel){
        val convertedItem = ReelMapper().reverse(reel)
        reelDao.insert(convertedItem)
    }

    override suspend fun getAll(id: Int): List<Reel> {
        TODO("Not yet implemented")
    }

    override suspend fun getBy(id: Int): Reel {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: Reel) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(entity: Reel) {
        TODO("Not yet implemented")
    }
}

class ReelMapper: ListTypeConverter<ReelEntity, Reel>() {

    override fun convert(source: ReelEntity): Reel =
        Reel(
            brand = source.brand,
            model = source.model,
            size = source.size.toInt()
        )

    override fun reverse(source: Reel): ReelEntity = ReelEntity(id = 0, brand = source.brand, model = source.model, size = source.size.toString())
}