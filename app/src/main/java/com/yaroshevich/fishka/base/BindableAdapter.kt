package com.yaroshevich.fishka.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishka.equipment.create.ViewHolder

open class BindableAdapter(val bindingType: Int): RecyclerView.Adapter<BindableViewHolder>() {

    var items = listOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BindableViewHolder(
            layoutInflater.inflate(
                viewType,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.binding?.setVariable(bindingType, items[position])
    }
}


class BindableViewHolder(view:View): RecyclerView.ViewHolder(view){
    val binding  = DataBindingUtil.bind<ViewDataBinding>(view)
}