package com.yaroshevich.fishka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yaroshevich.fishka.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
