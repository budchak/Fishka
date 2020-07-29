package com.yaroshevich.fishka.equipmentRV.itemClickListener

import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.navigation.AppNavigator

abstract class NavigationITemClickListener: ItemCLickListener {

    protected val navigator = App.getInstance().appNavigator

}