package com.yaroshevich.fishka.equipment.type.reels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yaroshevich.fishka.equipment.type.EmptyEquipmentDataFragment
import com.yaroshevich.fishka.equipment.type.FragmentEquipmentType
import com.yaroshevich.fishka.equipment.type.RecyclerViewFragment
import com.yaroshevich.fishka.equipment.type.reels.model.Reel
import com.yaroshevich.fishka.equipment.type.rods.EmptyRodViewModel
import com.yaroshevich.fishka.equipment.type.rods.RodViewModel

class ReelsFragment : FragmentEquipmentType() {

    val list = mutableListOf<Reel>()
    val reeAdapter = ReelAdapter()

    lateinit var emptyReelViewModel: EmptyReelsViewModel
    lateinit var reelViewModel: ReelsViewModel

    override fun get(fragmentType: Int): Fragment {
        return when (typeViewModel.fragmentType.value) {
            0 -> EmptyEquipmentDataFragment(
                emptyReelViewModel
            )
            else -> RecyclerViewFragment<Reel>(
               rvAdapter =  reeAdapter,
               typeViewModel =  reelViewModel
            )
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emptyReelViewModel = ViewModelProvider(this).get(EmptyReelsViewModel::class.java)
        reelViewModel = ViewModelProvider(this).get(ReelsViewModel::class.java)
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))
        list.add(Reel("tosiba", "5000", 210))


        reeAdapter.items = list
        reeAdapter.notifyDataSetChanged()
    }
}