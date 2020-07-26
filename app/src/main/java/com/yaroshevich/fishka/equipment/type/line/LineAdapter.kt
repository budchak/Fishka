package com.yaroshevich.fishka.equipment.type.line

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.adapters.BaseAdapter
import com.yaroshevich.fishka.adapters.BaseViewHolder
import com.yaroshevich.fishka.adapters.ItemCLickListener
import com.yaroshevich.fishka.adapters.ViewHolderFactory
import com.yaroshevich.fishka.databinding.ItemLineBinding

class LineAdapter : BaseAdapter<Line>() {

    override fun createViewHolderFactory(): ViewHolderFactory<Line> {
        TODO("Not yet implemented")
    }


    class LineViewHolder(view: View) : BaseViewHolder<Line>(view) {
        val binding = DataBindingUtil.bind<ItemLineBinding>(view)

        override fun bind(item: Line, click: ItemCLickListener?) {
            binding?.line = item
        }
    }

    class LineViewHolderFactory :
        ViewHolderFactory<Line> {

        override fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Line> {
            return LineViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_reel, parent, false)
            )
        }
    }
}