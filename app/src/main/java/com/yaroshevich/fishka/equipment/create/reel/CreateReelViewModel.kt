package com.yaroshevich.fishka.equipment.create.reel

import androidx.lifecycle.ViewModel
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.equipment.type.reels.model.Reel
import com.yaroshevich.fishka.navigation.Destination
import com.yaroshevich.fishka.repository.ReelRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateReelViewModel : ViewModel() {

    val reelRepository = ReelRepository()

    var brand = ""
    var model = ""
    var size = ""


    val brandTitle = "Марка"


    fun onApplyClick() {
        saveReel()
        App.getInstance().appNavigator.navigate(Destination.ROD_SCREEN)
    }

    private fun saveReel() {
        val reel = createReel()
        GlobalScope.launch {
            reelRepository.create(reel)
        }

    }

    private fun createReel() = Reel(
        brand = brand,
        model = model,
        size = size.toInt()

    )

}