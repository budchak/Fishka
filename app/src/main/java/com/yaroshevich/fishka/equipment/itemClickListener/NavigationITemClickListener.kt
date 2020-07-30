package com.yaroshevich.fishka.equipment.itemClickListener

import com.yaroshevich.fishka.App

abstract class NavigationITemClickListener: ItemCLickListener {

    protected val navigator = App.getInstance().appNavigator

}