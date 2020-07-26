package com.yaroshevich.fishka.equipment.type.reels

import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.base.EquipmentTypeViewModel
import com.yaroshevich.fishka.equipment.type.FragmentType
import com.yaroshevich.fishka.equipment.type.reels.model.Reel
import com.yaroshevich.fishka.navigation.Destination
import com.yaroshevich.fishka.repository.ReelRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ReelsViewModel : EquipmentTypeViewModel() {

    var reelRepository = ReelRepository()

    init {
        GlobalScope.launch {

            fragmentType.postValue(FragmentType.LOADING)

            val result = reelRepository.getAll()

            liveList.postValue(result)

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