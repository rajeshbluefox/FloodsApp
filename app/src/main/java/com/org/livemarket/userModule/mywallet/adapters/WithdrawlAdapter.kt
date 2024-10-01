package com.org.livemarket.userModule.mywallet.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.org.livemarket.databinding.ItemWithdrawBinding
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData


class WithdrawlAdapter(
    private var context: Context,
    private val calledFrom : Int,
    private var withdrawlList: List<WithdrawAmountData>,
    private val onWithDrawItemClicked: (withdrawItem: WithdrawAmountData) -> Unit,
    private val onApproveClicked: (withdrawItem: WithdrawAmountData, isApproved: Boolean) -> Unit
) :
    RecyclerView.Adapter<WithdrawlAdapter.WithdrawlAdapterViewHolder>() {


    class WithdrawlAdapterViewHolder(var binding: ItemWithdrawBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WithdrawlAdapterViewHolder {
        return WithdrawlAdapterViewHolder(
            ItemWithdrawBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: WithdrawlAdapterViewHolder, position: Int) {

        val withDrawItem = withdrawlList[position]

        if(calledFrom==1) {
            //User View
            holder.binding.userlt.visibility= View.VISIBLE
            holder.binding.adminLt.visibility=View.GONE

            holder.binding.tvAmount.text = withDrawItem.amount
            //TODO Add Date, Status

            holder.binding.itemWithdraw.setOnClickListener {
                onWithDrawItemClicked.invoke(withDrawItem)
            }

        }else{
            //Admin View
            holder.binding.userlt.visibility= View.GONE
            holder.binding.adminLt.visibility=View.VISIBLE

            holder.binding.tvAmount.text=withDrawItem.amount

            holder.binding.btApprove.setOnClickListener {
                onApproveClicked.invoke(withDrawItem,true)
            }

            holder.binding.btDeny.setOnClickListener {
                onApproveClicked.invoke(withDrawItem,false)
            }

        }
    }

    override fun getItemCount(): Int {
        return withdrawlList.size
    }

}