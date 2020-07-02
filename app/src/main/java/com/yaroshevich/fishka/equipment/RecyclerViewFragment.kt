package com.yaroshevich.fishka.equipment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.base.BaseAdapter
import com.yaroshevich.fishka.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_recycler_view.*

class RecyclerViewFragment<T>(var rvAdapter: BaseAdapter<T> ): BaseFragment() {


    override fun getLayout(): Int {
        return R.layout.fragment_recycler_view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = rvAdapter
            addItemDecoration(DividerItemDecoration(this@RecyclerViewFragment.context, 1))
        }
    }

    
}