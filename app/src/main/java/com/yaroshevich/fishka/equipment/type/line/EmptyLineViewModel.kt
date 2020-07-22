package com.yaroshevich.fishka.equipment.type.line

import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.base.EmptyEquipmentViewModel
import com.yaroshevich.fishka.navigation.Destination

class EmptyLineViewModel : EmptyEquipmentViewModel() {
    override fun onClick() {
        App.getInstance().appNavigator.navigate(Destination.CREATE_LINE_SCREEN)
    }
}