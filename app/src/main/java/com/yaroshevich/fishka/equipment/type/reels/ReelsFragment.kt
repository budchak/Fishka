package com.yaroshevich.fishka.equipment.type.reels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.di.module.ReelModule
import com.yaroshevich.fishka.equipment.type.*
import com.yaroshevich.fishka.equipment.type.empty.fragment.EmptyEquipmentDataFragment
import com.yaroshevich.fishka.equipment.type.base.LoadingFragment
import com.yaroshevich.fishka.equipment.type.base.RecyclerViewFragment
import com.yaroshevich.fishka.equipment.type.empty.viewModel.EmptyReelsViewModel
import javax.inject.Inject

class ReelsFragment : FragmentEquipmentType() {

    @Inject
    lateinit var reelAdapter: ReelAdapter

    @Inject
    lateinit var reelViewModel: ReelsViewModel


    val reelModule = App.getInstance().equipmentComponent.plus(ReelModule(this))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        reelModule.inject(this)

        typeViewModel = reelViewModel
        super.onViewCreated(view, savedInstanceState)
    }
}

class ReelFactory(val emptyReelViewModel: EmptyReelsViewModel, val reelAdapter: ReelAdapter, val reelViewModel: ReelsViewModel): EquipmentFactory() {
    override fun create(fragmentType: FragmentType): Fragment {
        return when (fragmentType) {
            FragmentType.EMPTY-> EmptyEquipmentDataFragment(
                emptyReelViewModel
            )
            FragmentType.LOADING -> LoadingFragment()
            FragmentType.REGULAR -> RecyclerViewFragment(
                rvAdapter = reelAdapter,
                typeViewModel = reelViewModel
            )
        }
    }
}