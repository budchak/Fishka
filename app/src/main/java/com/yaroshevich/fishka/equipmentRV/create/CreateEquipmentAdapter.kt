package com.yaroshevich.fishka.equipmentRV.create

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

open class CreateEquipmentAdapter: RecyclerView.Adapter<ViewHolder>() {

    var items = mutableListOf<BindingItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                viewType,
                parent,
                false
            )
        )
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].layoutId
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bindingItem = items[position]
        holder.binding?.setVariable(bindingItem.bindingId, bindingItem.viewModel)
    }
}


class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = DataBindingUtil.bind<ViewDataBinding>(view)
}


class BindingItem(val layoutId: Int, val bindingId: Int, val viewModel: ViewModel)
