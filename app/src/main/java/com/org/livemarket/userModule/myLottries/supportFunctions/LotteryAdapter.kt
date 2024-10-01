package com.org.livemarket.userModule.myLottries.supportFunctions

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.org.livemarket.databinding.ItemCompetitionBinding
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData



class LotteryAdapter(
    private var context: Context,
    private var competitionList: List<CompetitionData>,
    private val onJobClicked: (compItem: CompetitionData) -> Unit,
) :
    RecyclerView.Adapter<LotteryAdapter.LotteryAdapterViewHolder>() {


    class LotteryAdapterViewHolder(var binding: ItemCompetitionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LotteryAdapterViewHolder {
        return LotteryAdapterViewHolder(
            ItemCompetitionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: LotteryAdapterViewHolder, position: Int) {

        val compItem = competitionList[position]

        holder.binding.tvCompetitionName.text = compItem.name

        holder.binding.itemCompetition.setOnClickListener {
            onJobClicked.invoke(compItem)
        }

    }

    override fun getItemCount(): Int {
        return competitionList.size
    }

}