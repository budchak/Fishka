package com.yaroshevich.fishka.di.module

import android.content.Context
import com.yaroshevich.fishka.Fish.CreatingTrophyViewModel
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideCreatingViewModel(): CreatingTrophyViewModel = CreatingTrophyViewModel()
}