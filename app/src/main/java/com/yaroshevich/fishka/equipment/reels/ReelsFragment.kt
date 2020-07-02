package com.yaroshevich.fishka.equipment.reels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yaroshevich.fishka.equipment.EmptyListFragment
import com.yaroshevich.fishka.equipment.FragmentEquipmentType
import com.yaroshevich.fishka.equipment.RecyclerViewFragment
import com.yaroshevich.fishka.equipment.reels.model.Reel

class ReelsFragment : FragmentEquipmentType() {

    val list = mutableListOf<Reel>()
    val reeAdapter = ReelAdapter()

    override fun getFragment(): Fragment {
        return when (list.size) {
            0 -> EmptyListFragment()
            else -> RecyclerViewFragment(reeAdapter)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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