package com.yaroshevich.fishka.equipment.viewPagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yaroshevich.fishka.equipment.EquipmentSwitchViewModel
import com.yaroshevich.fishka.equipment.type.baits.BaitsFragment
import com.yaroshevich.fishka.equipment.type.line.LineFragment
import com.yaroshevich.fishka.equipment.type.reels.ReelsFragment
import com.yaroshevich.fishka.equipment.type.rods.RodsFragment

class EquipmentPagerAdapter(fragmentManager: FragmentManager, var countTab: Int) : FragmentPagerAdapter(fragmentManager, countTab) {



    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> RodsFragment()
            1 -> ReelsFragment()
            2 -> LineFragment()
            3 -> BaitsFragment()
            else -> RodsFragment()


        }

    override fun getPageTitle(position: Int): CharSequence? =
        when(position){
            0 -> "Rods"
            1 -> "Reels"
            2 -> "Line"
            3 -> "bait"
            else -> ""
    }


    override fun getCount() = 4
}