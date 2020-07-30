package com.yaroshevich.fishka.appFunction

import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishka.adapters.AnimateViewHolder

class ScrollListener: RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        recyclerView.forEachVisibleHolder { holder: AnimateViewHolder ->
            holder.rotation
                // Update the velocity.
                // The velocity is calculated by the vertical scroll offset.
                .setStartVelocity(holder.currentVelocity - dx * SCROLL_ROTATION_MAGNITUDE)
                // Start the animation. This does nothing if the animation is already running.
                .start()
        }
    }

    companion object {
        /** The magnitude of rotation while the list is scrolled. */
        private const val SCROLL_ROTATION_MAGNITUDE = 0.25f

        /** The magnitude of rotation while the list is over-scrolled. */
        private const val OVERSCROLL_ROTATION_MAGNITUDE = -10

        /** The magnitude of translation distance while the list is over-scrolled. */
        private const val OVERSCROLL_TRANSLATION_MAGNITUDE = 0.2f

        /** The magnitude of translation distance when the list reaches the edge on fling. */
        private const val FLING_TRANSLATION_MAGNITUDE = 0.5f
    }

}