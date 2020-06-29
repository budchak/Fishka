package com.yaroshevich.fishka.equipment.viewPagerAdapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yaroshevich.fishka.equipment.baits.BaitsFragment
import com.yaroshevich.fishka.equipment.line.LineFragment
import com.yaroshevich.fishka.equipment.reels.ReelsFragment
import com.yaroshevich.fishka.equipment.rods.RodsFragment

class EquipmentPagerAdapter(fragmentManager: FragmentManager, var countTab: Int): FragmentPagerAdapter(fragmentManager, countTab) {


    override fun getItem(position: Int): Fragment =
      when(position){
          0 -> RodsFragment()
          1 -> ReelsFragment()
          2 -> LineFragment()
          3 -> BaitsFragment()
          else -> RodsFragment()


      }



    override fun getCount(): Int {
       return countTab
    }
}