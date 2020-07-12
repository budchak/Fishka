package com.yaroshevich.fishka.equipment.create

import android.util.Log
import androidx.lifecycle.ViewModel
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.rods.Rod
import com.yaroshevich.fishka.equipment.type.rods.Test
import com.yaroshevich.fishka.navigation.Destination
import com.yaroshevich.fishka.repository.RodRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateRodViewModel : ViewModel() {

    val rodRepository = RodRepository()

    var brand = ""
    var model = ""
    var length = ""
    var minTest = ""
    var maxTest = ""


    fun onApplyClick() {
        Log.i(
            "CreateViewModel",
            "brand = $brand model = $model length = $length test: min $minTest max = $maxTest"
        )

        saveRod()

        App.getInstance().appNavigator.navigate(Destination.ROD_SCREEN)


    }


    private fun saveRod() {
        val rod = createRod()
        GlobalScope.launch {
            rodRepository.create(rod)
        }

    }

    private fun createRod() = Rod(
        brand = brand,
        model = model,
        height = length.toInt(),
        test = Test(min = minTest.toInt(), max = maxTest.toInt())

    )

}