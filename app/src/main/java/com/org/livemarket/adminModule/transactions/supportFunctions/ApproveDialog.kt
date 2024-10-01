package com.org.livemarket.adminModule.transactions.supportFunctions

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.org.livemarket.databinding.DialogApproveDnwBinding
import com.org.livemarket.userModule.mywallet.modalClass.DepositData
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData


class ApproveDialog(
    layoutInflater: LayoutInflater,
    context: Context,
    private val onApprovedClicked: (dialogType: Int, depositData: DepositData, withdrawAmountData: WithdrawAmountData) -> Unit

) {
    private val mLayoutInflater: LayoutInflater
    private val mContext: Context

    private var binding: DialogApproveDnwBinding
    private var dialog: AlertDialog.Builder
    private var messageBoxInstance: AlertDialog

    init {
        mLayoutInflater = layoutInflater
        mContext = context
        binding = DialogApproveDnwBinding.inflate(mLayoutInflater)
        dialog = AlertDialog.Builder(mContext).setView(binding.root)
        dialog.setCancelable(true)
        messageBoxInstance = dialog.create()

    }

    fun openApproveDialog(
        dialogType: Int,
        depositData: DepositData,
        withdrawAmountData: WithdrawAmountData,
        title: String
    ) {
        binding.mainTitle.text=title

        messageBoxInstance.show()

        binding.btYes.setOnClickListener {
            onApprovedClicked.invoke(dialogType, depositData, withdrawAmountData)
        }
        binding.btNo.setOnClickListener {
            closeApproveDialog()
        }
    }

    private fun closeApproveDialog() {
        messageBoxInstance.dismiss()
    }

}