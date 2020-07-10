package com.yaroshevich.fishka.equipment.type.rods

import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.EmptyEquipmentViewModel
import com.yaroshevich.fishka.equipment.type.EquipmentTypeViewModel
import com.yaroshevich.fishka.navigation.Destination

class EmptyRodViewModel : EmptyEquipmentViewModel() {

    var liveRods = MutableLiveData<List<Rod>>()

    lateinit var typeViewModel: EquipmentTypeViewModel

    var viewType = 0

    override fun onClick() {
        App.getInstance().appNavigator.navigate(Destination.CREATE_ROD_SCREEN)
        typeViewModel.fragmentType.value = 1
    }


}