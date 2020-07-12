package com.yaroshevich.fishka.repository

import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.rods.Rod
import com.yaroshevich.fishka.equipment.type.rods.Test
import com.yaroshevich.fishka.room.entities.RodEntity


class RodRepository() {

    var rodDao = App.getInstance().database.rodDao()

    suspend fun getAll(): List<Rod> {
        val rodEntityList = rodDao.getAll()

        val result = RodEntityToRodConverter().convert(rodEntityList)

        return result
    }

    suspend fun create(rod: Rod) {
        val entity = RodToRodEntityConverter().convert(rod)
        rodDao.insert(entity)
    }

}

class RodEntityToRodConverter {


    fun convert(source: RodEntity) {
        val destination = mutableListOf<Rod>()
    }

    fun convert(source: List<RodEntity>): List<Rod> {
        val destination = mutableListOf<Rod>()


        source.forEach {
            var rod = Rod(
                brand = it.brand,
                model = it.model,
                height = it.length.toInt(),
                test = Test(it.minTest, it.maxTest)
            )
            destination.add(rod)
        }


        return destination
    }


}

class RodToRodEntityConverter {

    fun convert(source: Rod): RodEntity {
        return RodEntity(
            id = 0,
            brand = source.brand,
            model = source.model,
            length = source.height.toString(),
            minTest = source.test.min,
            maxTest = source.test.max
        )
    }

}