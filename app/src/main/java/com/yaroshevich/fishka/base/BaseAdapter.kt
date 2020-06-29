package com.yaroshevich.fishka.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {


    var items = listOf<T>()
    var viewHolderFactory = createViewHolderFactory()

    abstract fun createViewHolderFactory(): ViewHolderFactory<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> =
        viewHolderFactory.getViewHolder(parent, viewType)


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position])
    }


}

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T)
}


interface ViewHolderFactory<T> {

    fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>
}

