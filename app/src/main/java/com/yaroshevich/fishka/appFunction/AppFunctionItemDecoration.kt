package com.yaroshevich.fishka.appFunction

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class AppFunctionItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        if (itemPosition > 1) {
            outRect.bottom = 40
            outRect.left = 40
            outRect.right = 40
            outRect.top = 40
        } else {
            outRect.bottom = 40
            outRect.left = 40
            outRect.right = 40
            outRect.top = 80
        }
        if (itemPosition % 2 == 0){
            outRect.right = 10

        }else{
            outRect.left = 10
        }

    }
}