package com.yaroshevich.fishka.equipment.type.rods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseAdapter
import com.yaroshevich.fishka.base.BaseViewHolder
import com.yaroshevich.fishka.base.ViewHolderFactory
import com.yaroshevich.fishka.databinding.ItemRodBinding

class RodsAdapter: BaseAdapter<Rod>() {
    override fun createViewHolderFactory(): ViewHolderFactory<Rod> {
       return RodViewHolderFactory()
    }


}


class RodsViewHolder(view: View): BaseViewHolder<Rod>(view){

    val binding = DataBindingUtil.bind<ItemRodBinding>(view)

    override fun bind(item: Rod){

        binding?.rod = item


    }
}

class RodViewHolderFactory: ViewHolderFactory<Rod> {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Rod> {
        return RodsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rod, parent, false))
    }
}

