package com.yaroshevich.fishka

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.yaroshevich.fishka.base.BaseActivity
import com.yaroshevich.fishka.navigation.AppNavigator
import kotlinx.android.synthetic.main.activity_main.*


class NavigationActivity : BaseActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        App.getInstance().appNavigator = AppNavigator(navController)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null){
            when(item.itemId){
                android.R.id.home -> navController.navigateUp()
            }
        }
        return true
    }


}

