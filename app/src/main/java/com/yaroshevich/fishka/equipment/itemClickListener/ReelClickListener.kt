package com.yaroshevich.fishka.equipment.itemClickListener

import com.yaroshevich.fishka.navigation.Destination

class ReelClickListener: NavigationITemClickListener() {

    override fun onClick(id: Int) {
        navigator.navigate(Destination.CREATE_REEL_SCREEN)
    }
}