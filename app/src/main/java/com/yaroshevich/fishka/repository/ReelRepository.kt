package com.yaroshevich.fishka.repository

import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.reels.model.Reel
import com.yaroshevich.fishka.room.Dao.ReelDao
import com.yaroshevich.fishka.room.entities.ReelEntity
import com.yaroshevich.fishka.util.ListTypeConverter

class ReelRepository {

    val reelDao = App.getInstance().database.reelDao()

   suspend fun getAll(): List<Reel>{
        val dataBaseResult = reelDao.getAll()

        return ReelMapper().convert(dataBaseResult)
    }

    suspend fun create(reel: Reel){
        val convertedItem = ReelMapper().reverse(reel)
        reelDao.insert(convertedItem)
    }
}

class ReelMapper: ListTypeConverter<ReelEntity, Reel>() {

    override fun convert(source: ReelEntity): Reel = Reel(brand = source.brand, model = source.model, size = source.size.toInt())

    override fun reverse(source: Reel): ReelEntity = ReelEntity(id = 0, brand = source.brand, model = source.model, size = source.size.toString())
}