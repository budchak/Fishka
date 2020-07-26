package com.yaroshevich.fishka.di.module

import android.content.Context
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.Fish.CreatingTrophyViewModel
import com.yaroshevich.fishka.navigation.AppNavigator
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideCreatingViewModel(): CreatingTrophyViewModel = CreatingTrophyViewModel()

    @Provides
    fun provideAppNavigator(): AppNavigator = App.getInstance().appNavigator
}