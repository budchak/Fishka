package com.yaroshevich.fishka.equipment.type.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaroshevich.fishka.equipment.type.FragmentType

open class EquipmentTypeViewModel : ViewModel() {


    var fragmentType = MutableLiveData<FragmentType>(
        FragmentType.LOADING
    )


   open fun get(viewType: FragmentType) {

    }

    open fun onFloatingButtonClick() {

    }
}

