package com.yaroshevich.fishka.adapters

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {


    var items = listOf<T>()
    var viewHolderFactory = createViewHolderFactory()

    var itemCLickListener: ItemCLickListener? = null

    abstract fun createViewHolderFactory(): ViewHolderFactory<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> =
        viewHolderFactory.getViewHolder(parent, viewType)


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position], itemCLickListener)
    }




}

interface Bindable<T>

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding  = DataBindingUtil.bind<ViewDataBinding>(view)
}

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T, click: ItemCLickListener? = null)
}


interface ViewHolderFactory<T> {

    fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>
}

interface ItemCLickListener{

    fun onClick(id: Int)


}

