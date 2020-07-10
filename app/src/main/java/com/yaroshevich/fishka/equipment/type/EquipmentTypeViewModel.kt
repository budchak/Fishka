package com.yaroshevich.fishka.equipment.type

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class EquipmentTypeViewModel : ViewModel() {


    var fragmentType = MutableLiveData<Int>(0)


    fun get(viewType: Int) {

    }

    open fun onFloatingButtonClick() {

    }
}