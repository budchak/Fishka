package com.yaroshevich.fishka.equipment.itemClickListener


import com.yaroshevich.fishka.navigation.Destination

class RodClickListener(): NavigationITemClickListener() {
    override fun onClick(id: Int) {
       navigator.navigate(Destination.CREATE_ROD_SCREEN)
    }
}