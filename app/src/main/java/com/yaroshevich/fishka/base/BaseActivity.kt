package com.yaroshevich.fishka.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    lateinit var LOG_TAG: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LOG_TAG = this.localClassName
        Log.i(LOG_TAG, "OnCreate")
    }


    override fun onStart() {
        super.onStart()
        Log.i(LOG_TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_TAG, "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "OnCreate")
    }
}