package com.yaroshevich.fishka.equipment.type.rods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.*
import com.yaroshevich.fishka.databinding.ItemRodBinding
import com.yaroshevich.fishka.equipment.type.rods.model.Rod

class RodsAdapter (bindingType: Int): BindableAdapter(bindingType) {


    override fun getItemViewType(position: Int): Int {
        return R.layout.item_rod
    }
}

