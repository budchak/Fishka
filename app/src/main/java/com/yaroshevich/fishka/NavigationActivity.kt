package com.yaroshevich.fishka

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseActivity
import com.yaroshevich.fishka.navigation.AppNavigator

class NavigationActivity : BaseActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        App.getInstance().appNavigator = AppNavigator(navController)

    }


}
