package com.yaroshevich.fishka.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.yaroshevich.fishka.R

abstract class BaseFragment: Fragment() {

    lateinit var LOG_TAG: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LOG_TAG = this.javaClass.name
        Log.i(LOG_TAG, "OnAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.i(LOG_TAG, "OnCreateView")
        return inflater.inflate(getLayout(), container, false)
    }



    @LayoutRes
    abstract fun getLayout():Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(LOG_TAG, "OnViewCreated")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_TAG, "OnPause")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(LOG_TAG, "OnDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "OnDestroy")
    }


}