package com.yaroshevich.fishka.equipment.type.rods

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.di.module.RodModule
import com.yaroshevich.fishka.equipment.type.*
import com.yaroshevich.fishka.equipment.type.empty.fragment.EmptyEquipmentDataFragment
import com.yaroshevich.fishka.equipment.type.base.LoadingFragment
import com.yaroshevich.fishka.equipment.type.base.RecyclerViewFragment
import com.yaroshevich.fishka.equipment.type.empty.viewModel.EmptyRodViewModel
import javax.inject.Inject

class RodsFragment: FragmentEquipmentType() {


    @Inject
    lateinit var rodViewModel: RodViewModel

    @Inject
    lateinit var rodsAdapter: RodsAdapter

    val rodComponent = App.getInstance().equipmentComponent.plus(RodModule(this))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rodComponent.inject(this)
        typeViewModel = rodViewModel
        super.onViewCreated(view, savedInstanceState)

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true ) {
                override fun handleOnBackPressed() {
                   App.getInstance().appNavigator.navigateToMainScreen()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }


}

class RodFactory(val emptyRodViewModel: EmptyRodViewModel,
                 val rodsAdapter: RodsAdapter,
                 val rodViewModel: RodViewModel): EquipmentFactory() {
    override fun create(id: FragmentType): Fragment {
        return when(id){
            FragmentType.EMPTY -> EmptyEquipmentDataFragment(emptyRodViewModel
            )
            FragmentType.REGULAR -> RecyclerViewFragment(
                rodsAdapter, rodViewModel
            )

            FragmentType.LOADING -> LoadingFragment()
        }
    }
}