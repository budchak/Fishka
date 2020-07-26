package com.yaroshevich.fishka.di.module

import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.di.spore.ViewSpore
import com.yaroshevich.fishka.equipment.type.EquipmentFactory
import com.yaroshevich.fishka.equipment.type.empty.viewModel.EmptyReelsViewModel
import com.yaroshevich.fishka.equipment.type.empty.viewModel.EmptyRodViewModel
import com.yaroshevich.fishka.equipment.type.reels.ReelAdapter
import com.yaroshevich.fishka.equipment.type.reels.ReelFactory
import com.yaroshevich.fishka.equipment.type.reels.ReelsFragment
import com.yaroshevich.fishka.equipment.type.reels.ReelsViewModel
import com.yaroshevich.fishka.equipment.type.rods.RodFactory
import com.yaroshevich.fishka.equipment.type.rods.RodViewModel
import com.yaroshevich.fishka.equipment.type.rods.RodsAdapter
import dagger.Module
import dagger.Provides


@Module
class ReelModule(var reelFragment: ReelsFragment) {


    @ViewSpore
    @Provides
    fun provideFactory(
        emptyReelViewModel: EmptyReelsViewModel,
        reelsAdapter: ReelAdapter,
        ReelViewModel: ReelsViewModel
    ): EquipmentFactory {

        return ReelFactory(emptyReelViewModel, reelsAdapter, ReelViewModel)
    }

    @ViewSpore
    @Provides
    fun provideEmptyReelViewModel(): EmptyReelsViewModel {
        return ViewModelProvider(reelFragment).get(EmptyReelsViewModel::class.java)
    }

    @ViewSpore
    @Provides
    fun provideReelAdapter(): ReelAdapter {
        return ReelAdapter(BR.Reel)
    }

    @ViewSpore
    @Provides
    fun provideReelViewModel(): ReelsViewModel {
        return ViewModelProvider(reelFragment).get(ReelsViewModel::class.java)
    }

}