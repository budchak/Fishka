package com.yaroshevich.fishka.di.module

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.Fish.CreatingTrophyViewModel
import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.navigation.AppNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideCreatingViewModel(): CreatingTrophyViewModel = CreatingTrophyViewModel()

    @Provides
    fun provideAppNavigator(): AppNavigator = App.getInstance().appNavigator

    @Singleton
    @Provides
    fun provideCurrentPosition(): MutableLiveData<Int> {
        return MutableLiveData(0)
    }
}