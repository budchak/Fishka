package com.yaroshevich.fishka.equipment.type.rods

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.adapters.ItemCLickListener
import com.yaroshevich.fishka.equipment.type.base.EquipmentTypeViewModel
import com.yaroshevich.fishka.equipment.type.FragmentType
import com.yaroshevich.fishka.equipment.type.rods.model.Rod
import com.yaroshevich.fishka.navigation.Destination
import com.yaroshevich.fishka.repository.RodRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RodViewModel : EquipmentTypeViewModel(),
    ItemCLickListener {


    var rodRepository = RodRepository()

    init {


        GlobalScope.launch {
            fragmentType.postValue(FragmentType.LOADING)
            val result = rodRepository.getAll()
            liveList.postValue(result)
            if (result.isNotEmpty()) {
                fragmentType.postValue(FragmentType.REGULAR)
            } else {
                fragmentType.postValue(FragmentType.EMPTY)
            }
        }

    }


    override fun onFloatingButtonClick() {
        Log.e("navigation", "вроде navigate working")
        App.getInstance().appNavigator.navigate(Destination.CREATE_ROD_SCREEN)
        fragmentType.value = FragmentType.REGULAR
    }



    override fun onClick(id: Int) {
        Log.e("tag", "click")
        App.getInstance().appNavigator.navigateToCreateRodScreen(id)
    }

}