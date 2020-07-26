package com.yaroshevich.fishka.repository

import android.util.Log
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.rods.model.Rod
import com.yaroshevich.fishka.equipment.type.rods.model.Test
import com.yaroshevich.fishka.room.entities.RodEntity
import com.yaroshevich.fishka.util.ListTypeConverter


class RodRepository() {

    var rodDao = App.getInstance().database.rodDao()

    suspend fun getAll(): List<Rod> {
        val rodEntityList = rodDao.getAll()

        val result = RodEntityToRodMapper().convert(rodEntityList)

        return result
    }

    suspend fun getById(id: Int): Rod{
        val rodEntity = rodDao.getById(id)
        if (rodEntity != null) {

            return RodEntityToRodMapper().convert(rodEntity)
        }

        return Rod()
    }

    suspend fun create(rod: Rod) {
        val entity = RodEntityToRodMapper().reverse(rod)

            Log.e("insert","${entity.id}")
            rodDao.insert(entity)


    }

    suspend fun update(rod: Rod){
        val entity = RodEntityToRodMapper().reverse(rod)
        rodDao.update(entity)
        Log.e("Update","${entity.id}")
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
