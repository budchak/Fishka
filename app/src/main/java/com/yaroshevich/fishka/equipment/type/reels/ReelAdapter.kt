package com.yaroshevich.fishka.equipment.type.reels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.*
import com.yaroshevich.fishka.databinding.ItemReelBinding
import com.yaroshevich.fishka.databinding.ItemRodBinding
import com.yaroshevich.fishka.equipment.type.reels.model.Reel

class ReelAdapter(bindingViewType: Int) : BindableAdapter(bindingViewType) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_reel
    }


}
