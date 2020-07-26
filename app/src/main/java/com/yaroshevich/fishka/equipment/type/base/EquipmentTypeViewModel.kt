package com.yaroshevich.fishka.equipment.type.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaroshevich.fishka.equipment.type.FragmentType
import com.yaroshevich.fishka.equipment.type.reels.model.Reel

open class EquipmentTypeViewModel : ViewModel() {

    var liveList = MutableLiveData<List<Any>>()


    var fragmentType = MutableLiveData<FragmentType>(
        FragmentType.LOADING
    )


   open fun get(viewType: FragmentType) {

    }

    open fun onFloatingButtonClick() {

    }
}

