package com.yaroshevich.fishka.equipment.type.empty.viewModel

import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.base.EquipmentTypeViewModel
import com.yaroshevich.fishka.navigation.Destination

class EmptyRodViewModel : EmptyEquipmentViewModel() {

    lateinit var typeViewModel: EquipmentTypeViewModel

    var viewType = 0

    override fun onClick() {
        App.getInstance().appNavigator.navigate(Destination.CREATE_ROD_SCREEN)
    }


}