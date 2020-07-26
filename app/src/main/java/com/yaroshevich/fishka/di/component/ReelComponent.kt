package com.yaroshevich.fishka.di.component

import com.yaroshevich.fishka.di.module.ReelModule
import com.yaroshevich.fishka.di.spore.ViewSpore
import com.yaroshevich.fishka.equipment.type.reels.ReelsFragment
import dagger.Subcomponent


@ViewSpore
@Subcomponent(modules = [ReelModule::class])
interface ReelComponent {
    fun inject(fragment: ReelsFragment)
}