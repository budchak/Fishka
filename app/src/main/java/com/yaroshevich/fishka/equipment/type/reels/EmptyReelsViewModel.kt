package com.yaroshevich.fishka.equipment.type.reels

import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishka.equipment.type.EmptyEquipmentViewModel
import com.yaroshevich.fishka.equipment.type.reels.model.Reel


class EmptyReelsViewModel : EmptyEquipmentViewModel() {

    var liveRods = MutableLiveData<List<Reel>>()

    var viewType = 0

    override fun onClick() {
        val reel = Reel(brand = "daiva", model = "4000", size = 2544)
        val list = mutableListOf<Reel>()

        val value = liveRods.value
        if (value != null){
            list.addAll(value)
        }

        list.add(reel)
        liveRods.value = list
        viewType = 1
    }

}