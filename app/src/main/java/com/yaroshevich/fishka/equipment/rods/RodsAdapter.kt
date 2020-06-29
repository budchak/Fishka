package com.yaroshevich.fishka.equipment.rods

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseAdapter
import com.yaroshevich.fishka.base.BaseViewHolder
import com.yaroshevich.fishka.base.ViewHolderFactory
import kotlinx.android.synthetic.main.item_rod.view.*

class RodsAdapter: BaseAdapter<Rod>() {
    override fun createViewHolderFactory(): ViewHolderFactory<Rod> {
       return RodViewHolderFactory()
    }


}


class RodsViewHolder(view: View): BaseViewHolder<Rod>(view){


    override fun bind(rod: Rod){
        itemView.apply {
            brand_text_view.text = rod.brand
            model_text_view.text = rod.model
            lenght_text_view.text = rod.height.toString()

            val min = rod.test.min
            val max = rod.test.max
            test_text_view.text = "${min.toString()} - ${max.toString()}"
        }
    }
}

class RodViewHolderFactory: ViewHolderFactory<Rod> {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Rod> {
        return RodsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rod, parent, false))
    }
}

