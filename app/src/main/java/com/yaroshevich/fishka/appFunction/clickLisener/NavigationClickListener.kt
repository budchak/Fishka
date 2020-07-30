package com.yaroshevich.fishka.appFunction.clickLisener

import android.view.View
import com.yaroshevich.fishka.navigation.AppNavigator
import com.yaroshevich.fishka.navigation.Destination

class NavigationClickListener(val navigator: AppNavigator, val destination: Destination): View.OnClickListener {


    override fun onClick(v: View?) {
        navigator.navigate(destination)
    }

}