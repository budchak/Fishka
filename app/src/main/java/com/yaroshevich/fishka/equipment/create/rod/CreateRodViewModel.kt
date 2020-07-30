package com.yaroshevich.fishka.equipment.create.rod

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.model.Rod
import com.yaroshevich.fishka.model.Test
import com.yaroshevich.fishka.navigation.Destination
import com.yaroshevich.fishka.repository.RodRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateRodViewModel : ViewModel() {

    val rodRepository = RodRepository()

    var brand = MutableLiveData<String>("")
    var model = MutableLiveData<String>("")
    var length = MutableLiveData<String>("")
    var minTest = MutableLiveData<String>("")
    var maxTest = MutableLiveData<String>("")

    var id = 0

    fun onApplyClick() {
        Log.i(
            "CreateViewModel",
            "brand = $brand model = $model length = $length test: min $minTest max = $maxTest"
        )

        saveRod()

        App.getInstance().appNavigator.navigate(Destination.EQUIPMENT_SCREEN)


    }

    fun load(id: Int) {
        this.id = id
        GlobalScope.launch {
            val rod = rodRepository.getBy(id)
            brand.postValue(rod.brand)
            model.postValue(rod.model)
            length.postValue(rod.height.toString())
            minTest.postValue(rod.test.min.toString())
            maxTest.postValue(rod.test.max.toString())
        }
    }

    private fun saveRod() {
        val rod = createRod()
        GlobalScope.launch {
            if (id == 0){
                rodRepository.create(rod)
            }else{
                rodRepository.update(rod)
            }

        }

    }

    private fun createRod() = Rod(
        id = id,
        brand = brand.value!!,
        model = model.value!!,
        height = length.value!!.toInt(),
        test = Test(
            min = minTest.value!!.toInt(),
            max = maxTest.value!!.toInt()
        )

    )

}