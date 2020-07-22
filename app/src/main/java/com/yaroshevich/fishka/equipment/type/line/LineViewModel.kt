package com.yaroshevich.fishka.equipment.type.line

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.FragmentType
import com.yaroshevich.fishka.equipment.type.base.EquipmentTypeViewModel
import com.yaroshevich.fishka.navigation.Destination
import com.yaroshevich.fishka.repository.LineRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LineViewModel: EquipmentTypeViewModel() {

    var lineRepository = LineRepository()

    var reelLiveList = MutableLiveData<List<Line>>()

    init {
        GlobalScope.launch {

            fragmentType.postValue(FragmentType.LOADING)

            val result = lineRepository.getAll()

            reelLiveList.postValue(result)

            if (result.isNotEmpty()) {
                fragmentType.postValue(FragmentType.REGULAR)
            } else {
                fragmentType.postValue(FragmentType.EMPTY)
            }
        }
    }

    override fun onFloatingButtonClick() {
        super.onFloatingButtonClick()
        App.getInstance().appNavigator.navigate(Destination.CREATE_REEL_SCREEN)
    }

}



class EquipmentViewModelBuilder(val lifecycleOwner: LifecycleOwner, val clazz: Class<Any>){



}