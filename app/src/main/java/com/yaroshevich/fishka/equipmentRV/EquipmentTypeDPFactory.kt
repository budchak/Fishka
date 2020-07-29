package com.yaroshevich.fishka.equipmentRV

import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.equipmentRV.itemClickListener.ReelClickListener
import com.yaroshevich.fishka.equipmentRV.itemClickListener.RodClickListener
import com.yaroshevich.fishka.repository.ReelRepository
import com.yaroshevich.fishka.repository.RodRepository

class EquipmentTypeDPFactory {

    fun getD(id: Int): EquipmentDP {
        return when (id) {
            0 -> EquipmentDP(EquipmentAdapter(BR.rod, R.layout.item_rod, RodClickListener()), RodRepository() )
            1 -> EquipmentDP(EquipmentAdapter(BR.Reel, R.layout.item_reel, ReelClickListener()), ReelRepository())
            else -> EquipmentDP(EquipmentAdapter(BR.rod, R.layout.item_rod), RodRepository())
        }
    }
}