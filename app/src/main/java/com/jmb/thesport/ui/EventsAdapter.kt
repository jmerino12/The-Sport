package com.jmb.thesport.ui


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jmb.thesport.base.BaseViewHolder
import com.jmb.thesport.data.model.response.Event
import com.jmb.thesport.data.model.response.Events
import com.jmb.thesport.data.model.response.Team
import com.jmb.thesport.databinding.ItemComponentBinding
import com.jmb.thesport.databinding.ItemEventosBinding


/**
 * Created by Jonathan Meriño Bolivar on 2/07/2021.
 */
class EventsAdapter(
    private val context: Context,
    private val teamList: List<Event>,
) : RecyclerView.Adapter<BaseViewHolder<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val viewBinding =
            ItemEventosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(teamList[position], position)
        }
    }

    override fun getItemCount(): Int = 5

    inner class MainViewHolder(private val viewBinding: ItemEventosBinding) :
        BaseViewHolder<Event>(viewBinding.root) {
        override fun bind(item: Event, position: Int) {
            Glide.with(context).load(item.strThumb).into(viewBinding.phto)
            viewBinding.tvEvento.text = "${item.strEvent} - ${item.dateEvent}"
        }

    }
}