package com.yaroshevich.fishka.di.module

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.adapters.BindableViewHolder
import com.yaroshevich.fishka.appFunction.*
import com.yaroshevich.fishka.appFunction.clickLisener.NavigationClickListener
import com.yaroshevich.fishka.di.spore.FragmentSpore
import com.yaroshevich.fishka.navigation.AppNavigator
import com.yaroshevich.fishka.navigation.Destination
import dagger.Module
import dagger.Provides


@Module
class AppFunctionModule(val fragment: AppFunctionFragment) {

    @FragmentSpore
    @Provides
    fun provideContext(): Context = fragment.context!!

    @FragmentSpore
    @Provides
    fun provideAdapter(): RecyclerView.Adapter<BindableViewHolder> = AppFunctionAdapter()

    @FragmentSpore
    @Provides
    fun provideLayoutInflater(context: Context): RecyclerView.LayoutManager = GridLayoutManager(context, 2 , RecyclerView.VERTICAL, false)

    @FragmentSpore
    @Provides
    fun provideViewModel(function: List<ItemViewModel>): AppFunctionViewModel  = AppFunctionViewModel(function)

    @FragmentSpore
    @Provides
    fun provideFunctionList(context: Context?, navigator: AppNavigator): List<ItemViewModel>{
        val list = mutableListOf<ItemViewModel>()
        val drawable = context?.getDrawable(R.drawable.fish_icon)
        if (drawable != null){
            list.add(
                ItemViewModel(
                    AppFunction(drawable, "Снаряжение"),
                    NavigationClickListener(navigator, Destination.EQUIPMENT_SCREEN)
                )
            )
            list.add(
                ItemViewModel(
                    AppFunction(drawable, "Рыбалки")
                )
            )
            list.add(
                ItemViewModel(
                    AppFunction(drawable, "Погода")
                )
            )

        }
        return list
    }



    @Provides
    fun provideScrollListener(): RecyclerView.OnScrollListener  = ScrollListener()

    @Provides
    fun provideEdgeEffectFactory(): RecyclerView.EdgeEffectFactory = BounceEdgeEffectFactory()
}