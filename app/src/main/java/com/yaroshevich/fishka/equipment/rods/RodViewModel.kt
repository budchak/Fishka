package com.yaroshevich.fishka.equipment.rods

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RodViewModel : ViewModel() {

    var liveRods = MutableLiveData<List<Rod>>()

    var viewType = 0


    fun update() {
        val rod = Rod(brand = "daiva", model = "4000", height = 500, test = Test(4, 10))
        val list = mutableListOf<Rod>()
        list.addAll(liveRods.value!!)
        list.add(rod)
        liveRods.value = list
        viewType = 1
    }

}