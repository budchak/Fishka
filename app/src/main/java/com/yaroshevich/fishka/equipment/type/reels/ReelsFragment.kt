package com.yaroshevich.fishka.equipment.type.reels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.equipment.type.*
import com.yaroshevich.fishka.equipment.type.base.EmptyEquipmentDataFragment
import com.yaroshevich.fishka.equipment.type.base.LoadingFragment
import com.yaroshevich.fishka.equipment.type.base.RecyclerViewFragment
import com.yaroshevich.fishka.equipment.type.rods.RodsAdapter

class ReelsFragment : FragmentEquipmentType() {


    private val reelAdapter = ReelAdapter(BR.Reel)

    lateinit var emptyReelViewModel: EmptyReelsViewModel
    lateinit var reelViewModel: ReelsViewModel

    fun get(fragmentType: FragmentType): Fragment {
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        emptyReelViewModel = ViewModelProvider(this).get(EmptyReelsViewModel::class.java)
        reelViewModel = ViewModelProvider(this).get(ReelsViewModel::class.java)
        typeViewModel = reelViewModel

        super.onViewCreated(view, savedInstanceState)
        reelViewModel.reelLiveList.observe(viewLifecycleOwner, Observer {
            reelAdapter.items = it
            reelAdapter.notifyDataSetChanged()
        })
    }
}