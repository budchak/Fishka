package com.yaroshevich.fishka.equipment.type.reels

import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.base.EmptyEquipmentViewModel
import com.yaroshevich.fishka.navigation.Destination


class EmptyReelsViewModel : EmptyEquipmentViewModel() {

    override fun onClick() {
        App.getInstance().appNavigator.navigate(Destination.CREATE_REEL_SCREEN)
    }

}