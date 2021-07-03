package com.jmb.thesport.ui


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jmb.thesport.base.BaseViewHolder
import com.jmb.thesport.data.model.response.Team
import com.jmb.thesport.databinding.ItemComponentBinding


/**
 * Created by Jonathan Meriño Bolivar on 2/07/2021.
 */
class HomeAdapter(
    private val context: Context,
    private val teamList: List<Team>,
    private val itemClickListener: OnTeamClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTeamClickListener {
        fun onTeamClick(team: Team)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val viewBinding =
            ItemComponentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(teamList[position], position)
        }
    }

    override fun getItemCount(): Int = teamList.size

    inner class MainViewHolder(private val viewBinding: ItemComponentBinding) :
        BaseViewHolder<Team>(viewBinding.root) {
        override fun bind(item: Team, position: Int) {
            Glide.with(context).load(item.strTeamBadge).into(viewBinding.escudoEquipo)
            Glide.with(context).load(item.strStadiumThumb).into(viewBinding.phto)

            viewBinding.nombreEquipo.text = item.strTeam
            viewBinding.nombreEstadio.text = item.strStadium

            viewBinding.root.setOnClickListener {
                itemClickListener.onTeamClick(item)
            }


        }

    }
}