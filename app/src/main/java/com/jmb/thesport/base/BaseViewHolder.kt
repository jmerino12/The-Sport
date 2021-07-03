package com.jmb.thesport.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Jonathan Meriño Bolivar on 2/07/2021.
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(itemView: T, position: Int)
}