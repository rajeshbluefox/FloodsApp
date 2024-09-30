package com.org.livemarket.userModule.competitions.supportFunctions

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.org.livemarket.databinding.ItemCompetitionBinding
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData


class CompetitionsAdapter(
    private var context: Context,
    private var competitionList: List<CompetitionData>,
    private val onJobClicked: (compItem: CompetitionData) -> Unit,
) :
    RecyclerView.Adapter<CompetitionsAdapter.CompetitionsAdapterViewHolder>() {


    class CompetitionsAdapterViewHolder(var binding: ItemCompetitionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompetitionsAdapterViewHolder {
        return CompetitionsAdapterViewHolder(
            ItemCompetitionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: CompetitionsAdapterViewHolder, position: Int) {

        val compItem = competitionList[position]


        holder.binding.itemCompetition.setOnClickListener {
            onJobClicked.invoke(compItem)
        }

    }

    override fun getItemCount(): Int {
        return competitionList.size
    }

}