package com.yaroshevich.fishka.equipment.type.rods

import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.adapters.BindableAdapter
import com.yaroshevich.fishka.adapters.BindableViewHolder
import com.yaroshevich.fishka.adapters.ItemCLickListener

class RodsAdapter (bindingType: Int, var itemCLickListener: ItemCLickListener): BindableAdapter(bindingType) {

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.binding?.setVariable(BR.clickListener, itemCLickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_rod
    }
}

