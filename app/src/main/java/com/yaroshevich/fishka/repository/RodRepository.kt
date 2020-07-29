package com.yaroshevich.fishka.repository

import android.util.Log
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.model.Rod
import com.yaroshevich.fishka.model.Test
import com.yaroshevich.fishka.room.entities.RodEntity
import com.yaroshevich.fishka.util.ListTypeConverter


class RodRepository : EquipmentRepository<Rod> {

    var rodDao = App.getInstance().database.rodDao()

    override suspend fun getAll(): List<Rod> {
        val rodEntityList = rodDao.getAll()

        val result = RodEntityToRodMapper().convert(rodEntityList)

        return result
    }

    override suspend fun getBy(id: Int): Rod {
        val rodEntity = rodDao.getById(id)
        if (rodEntity != null) {

            return RodEntityToRodMapper().convert(rodEntity)
        }

        return Rod()
    }

    override suspend fun create(rod: Rod) {
        val entity = RodEntityToRodMapper().reverse(rod)

        Log.e("insert", "${entity.id}")
        rodDao.insert(entity)


    }

    override suspend fun update(rod: Rod) {
        val entity = RodEntityToRodMapper().reverse(rod)
        rodDao.update(entity)
        Log.e("Update", "${entity.id}")
    }

    override suspend fun getAll(id: Int): List<Rod> {
        return mutableListOf()
    }


    override suspend fun delete(entity: Rod) {

    }

}

class RodEntityToRodMapper : ListTypeConverter<RodEntity, Rod>() {


    override fun convert(source: RodEntity): Rod {


        return Rod(
            id = source.id,
            brand = source.brand,
            model = source.model,
            height = source.length.toInt(),
            test = Test(
                source.minTest,
                source.maxTest
            )
        )

    }

    override fun reverse(source: Rod): RodEntity {
        return RodEntity(
            id = source.id,
            brand = source.brand,
            model = source.model,
            length = source.height.toString(),
            minTest = source.test.min,
            maxTest = source.test.max
        )
    }


}
