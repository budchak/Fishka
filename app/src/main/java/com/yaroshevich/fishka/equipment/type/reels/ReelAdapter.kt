package com.yaroshevich.fishka.equipment.type.reels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseAdapter
import com.yaroshevich.fishka.base.BaseViewHolder
import com.yaroshevich.fishka.base.ViewHolderFactory
import com.yaroshevich.fishka.equipment.type.reels.model.Reel

class ReelAdapter: BaseAdapter<Reel>() {
    override fun createViewHolderFactory(): ViewHolderFactory<Reel> {
        return ReelViewHolderFactory()
    }
}

class ReelViewHolder(view: View): BaseViewHolder<Reel>(view) {
    override fun bind(item: Reel) {

    }
}

class ReelViewHolderFactory: ViewHolderFactory<Reel> {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Reel> {
        return ReelViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_reel, parent, false))
    }
}