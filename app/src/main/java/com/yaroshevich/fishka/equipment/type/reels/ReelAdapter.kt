package com.yaroshevich.fishka.equipment.type.reels

import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.adapters.BindableAdapter

class ReelAdapter(bindingViewType: Int) : BindableAdapter(bindingViewType) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_reel
    }


}
