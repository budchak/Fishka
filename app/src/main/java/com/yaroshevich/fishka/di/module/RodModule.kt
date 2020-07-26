package com.yaroshevich.fishka.di.module

import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.di.spore.ViewSpore
import com.yaroshevich.fishka.equipment.type.EquipmentFactory
import com.yaroshevich.fishka.equipment.type.empty.viewModel.EmptyRodViewModel
import com.yaroshevich.fishka.equipment.type.rods.RodFactory
import com.yaroshevich.fishka.equipment.type.rods.RodViewModel
import com.yaroshevich.fishka.equipment.type.rods.RodsAdapter
import com.yaroshevich.fishka.equipment.type.rods.RodsFragment
import dagger.Module
import dagger.Provides

@Module
class RodModule(var rodFragment: RodsFragment) {

    @ViewSpore
    @Provides
    fun provideRodFactory(
        emptyRodViewModel: EmptyRodViewModel,
        rodsAdapter: RodsAdapter,
        rodViewModel: RodViewModel
    ): EquipmentFactory {

        return RodFactory(emptyRodViewModel, rodsAdapter, rodViewModel)
    }

    @ViewSpore
    @Provides
    fun provideEmptyRodViewModel(): EmptyRodViewModel{
        return ViewModelProvider(rodFragment).get(EmptyRodViewModel::class.java)
    }

    @ViewSpore
    @Provides
    fun provideRodAdapter(rodViewModel: RodViewModel): RodsAdapter {
        return RodsAdapter(BR.rod, rodViewModel)
    }

    @ViewSpore
    @Provides
    fun provideRodViewModel(): RodViewModel{
        return ViewModelProvider(rodFragment).get(RodViewModel::class.java)
    }
}