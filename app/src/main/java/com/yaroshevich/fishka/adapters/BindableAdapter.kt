package com.yaroshevich.fishka.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.recyclerview.widget.RecyclerView
import java.lang.ClassCastException

open class BindableAdapter(val bindingType: Int): RecyclerView.Adapter<BindableViewHolder>() {

    var items = listOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimateViewHolder(
            layoutInflater.inflate(
                viewType,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {

        holder.binding?.setVariable(bindingType, items[position])




    }
}


open class BindableViewHolder(view:View): RecyclerView.ViewHolder(view){
    val binding  = DataBindingUtil.bind<ViewDataBinding>(view)
}

class AnimateViewHolder(view: View): BindableViewHolder(view){
    var currentVelocity = 0f

    val rotation: SpringAnimation = SpringAnimation(itemView, SpringAnimation.ROTATION)
        .setSpring(
            SpringForce()
                .setFinalPosition(0f)
                .setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_LOW)
        )
        .addUpdateListener { _, _, velocity ->
            currentVelocity = velocity
        }

    val translationY: SpringAnimation = SpringAnimation(itemView, SpringAnimation.TRANSLATION_Y)
        .setSpring(
            SpringForce()
                .setFinalPosition(0f)
                .setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_LOW)
        )
}