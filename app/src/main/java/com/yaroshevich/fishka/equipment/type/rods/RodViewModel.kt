package com.yaroshevich.fishka.equipment.type.rods

import android.util.Log
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.EquipmentTypeViewModel
import com.yaroshevich.fishka.navigation.Destination

class RodViewModel: EquipmentTypeViewModel() {


    var rods = App.getInstance().rods

    init {
        fragmentType.value = when(rods.size){
            0 -> 0
            else -> 1
        }
    }


    override fun onFloatingButtonClick() {
        Log.e("navigation", "вроде navigate working")
        App.getInstance()?.appNavigator?.navigate(Destination.CREATE_ROD_SCREEN)
        fragmentType.value = 1
    }

}