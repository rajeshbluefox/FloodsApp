package com.org.livemarket.userModule.mywallet.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.org.livemarket.databinding.ItemDepositBinding
import com.org.livemarket.userModule.mywallet.modalClass.DepositData


class DepositAdapter(
    private var context: Context,
    private var calledFrom : Int,
    private var depositList: List<DepositData>,
    private val onDepositClicked: (depositItem: DepositData) -> Unit,
    private val onApproveClicked: (depositItem: DepositData,isApproved: Boolean) -> Unit
    ) : RecyclerView.Adapter<DepositAdapter.DepositAdapterViewHolder>() {


    class DepositAdapterViewHolder(var binding: ItemDepositBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DepositAdapterViewHolder {
        return DepositAdapterViewHolder(
            ItemDepositBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: DepositAdapterViewHolder, position: Int) {

        val depositItem = depositList[position]

        if(calledFrom==1) {
            //User Deposit History
            holder.binding.userLt.visibility=View.VISIBLE
            holder.binding.adminLt.visibility=View.GONE

            holder.binding.tvAmount.text = depositItem.amount
            //TODO Add Date, Status

            holder.binding.itemDeposit.setOnClickListener {
                onDepositClicked.invoke(depositItem)
            }

        }else{
            //Admin Approve Deposits
            holder.binding.userLt.visibility=View.GONE
            holder.binding.adminLt.visibility=View.VISIBLE

            holder.binding.atvAmount.text=depositItem.amount

            holder.binding.btApprove.setOnClickListener {
                onApproveClicked.invoke(depositItem,true)
            }

            holder.binding.btDeny.setOnClickListener {
                onApproveClicked.invoke(depositItem,false)
            }
        }
    }

    override fun getItemCount(): Int {
        return depositList.size
    }

}