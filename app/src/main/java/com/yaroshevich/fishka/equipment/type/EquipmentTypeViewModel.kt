package com.yaroshevich.fishka.equipment.type

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class EquipmentTypeViewModel : ViewModel() {


    var fragmentType = MutableLiveData<FragmentType>(FragmentType.LOADING)


   open fun get(viewType: FragmentType) {

    }

    open fun onFloatingButtonClick() {

    }
}

