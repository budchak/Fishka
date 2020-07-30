package com.yaroshevich.fishka.appFunction

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishka.App
import com.yaroshevich.fishka.R
import com.yaroshevich.fishka.adapters.BindableViewHolder
import com.yaroshevich.fishka.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_app_function.*
import javax.inject.Inject


class AppFunctionFragment : BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_app_function

    @Inject
    lateinit var layoutManager: RecyclerView.LayoutManager

    @Inject
    lateinit var adapter: RecyclerView.Adapter<BindableViewHolder>

    @Inject
    lateinit var viewModel: AppFunctionViewModel

    @Inject
    lateinit var edgeEffectFactory: RecyclerView.EdgeEffectFactory

    @Inject
    lateinit var scrollListener: RecyclerView.OnScrollListener


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.getInstance().initFunctionComponent(this)
        App.getInstance().appFunctionComponent.inject(this)
        (adapter as AppFunctionAdapter).items = viewModel.functions
        recycler_view.adapter = adapter
        recycler_view.layoutManager = layoutManager
        recycler_view.edgeEffectFactory = edgeEffectFactory
        recycler_view.addOnScrollListener(scrollListener)
        recycler_view.addItemDecoration(AppFunctionItemDecoration())


        initToolbar(toolbar4)

    }


    private fun initToolbar(toolbar: Toolbar ) {
        toolbar.title = "Fishka"
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
    }
}