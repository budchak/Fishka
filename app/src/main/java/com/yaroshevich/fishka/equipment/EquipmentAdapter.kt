package com.yaroshevich.fishka.equipment

import com.yaroshevich.fishka.BR
import com.yaroshevich.fishka.adapters.BindableAdapter
import com.yaroshevich.fishka.adapters.BindableViewHolder
import com.yaroshevich.fishka.equipment.itemClickListener.ItemCLickListener


class EquipmentAdapter(bindType: Int, val viewType: Int, var itemCLickListener: ItemCLickListener? = null): BindableAdapter(bindType) {

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding?.setVariable(BR.itemClickListener, itemCLickListener)


    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }





}