package com.org.livemarket.userModule.mywallet.supportFunctions

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.org.livemarket.databinding.DialogAddDepositBinding
import com.org.livemarket.userModule.mywallet.modalClass.DepositData
import com.org.livemarket.zCommonFuntions.UtilFunctions


class AddDepositDialog(
    layoutInflater: LayoutInflater,
    context: Context,
    private val onSubmitClicked: (depositData: DepositData) -> Unit

) {
    private val mLayoutInflater: LayoutInflater
    private val mContext: Context

    private var binding: DialogAddDepositBinding
    private var dialog: AlertDialog.Builder
    private var messageBoxInstance: AlertDialog

    init {
        mLayoutInflater = layoutInflater
        mContext = context
        binding = DialogAddDepositBinding.inflate(mLayoutInflater)
        dialog = AlertDialog.Builder(mContext).setView(binding.root)
        dialog.setCancelable(true)
        messageBoxInstance = dialog.create()

        onClickListener()
    }

    private fun onClickListener() {
        binding.btSubmit.setOnClickListener {
            getValues()
        }
    }

    fun getValues() {
        val amount = binding.etAmount.text.toString()
        val referenceNo = binding.etReferenceNo.text.toString()


        if (amount.isEmpty()) {
            UtilFunctions.showToast(mContext, "Please enter amount")
            return
        }

        if (referenceNo.isEmpty()) {
            UtilFunctions.showToast(mContext, "Please enter reference no")
            return
        }

        val depositData = DepositData()
        depositData.amount = amount
        depositData.referenceNo = referenceNo

        onSubmitClicked.invoke(depositData)

    }

    fun openDepositDialog() {
        messageBoxInstance.show()
    }

    private fun closeDepositDialog() {
        messageBoxInstance.dismiss()
    }

}