package com.org.livemarket.userModule.mywallet.supportFunctions

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.org.livemarket.databinding.DialogWithdrawBinding
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData
import com.org.livemarket.zCommonFuntions.UtilFunctions


class AddWithdrawlDialog(
    layoutInflater: LayoutInflater,
    context: Context,
    private val onSubmitClicked: (withDrawAmountData: WithdrawAmountData) -> Unit

) {
    private val mLayoutInflater: LayoutInflater = layoutInflater
    private val mContext: Context = context

    private var binding: DialogWithdrawBinding = DialogWithdrawBinding.inflate(mLayoutInflater)
    private var dialog: AlertDialog.Builder = AlertDialog.Builder(mContext).setView(binding.root)
    private var messageBoxInstance: AlertDialog

    private var selWithDrawMode = 0

    init {
        dialog.setCancelable(true)
        messageBoxInstance = dialog.create()

        radioButtonListeners()
        onClickListeners()
    }

    private fun onClickListeners()
    {
        binding.btSubmit.setOnClickListener {
            getValues()
        }
    }

    private fun getValues()
    {
        val amount = binding.etAmount.text.toString()

        val upiId=binding.etUPIId.text.toString()

        val accHolderName = binding.etAccHolderName.text.toString()
        val accNumber = binding.etAccHolderName.text.toString()
        val ifscCode = binding.etIFSCCode.text.toString()
        val bankName = binding.etBankName.text.toString()

        if(amount.isEmpty())
        {
            UtilFunctions.showToast(mContext,"Please enter amount")
            return
        }

        if(selWithDrawMode==1)
        {
            if(upiId.isEmpty())
            {
                UtilFunctions.showToast(mContext,"Please enter UPI ID")
                return
            }
        }else{
            if(accHolderName.isEmpty())
            {
                UtilFunctions.showToast(mContext,"Please enter Account Holder Name")
                return
            }

            if(accNumber.isEmpty()) {
                UtilFunctions.showToast(mContext, "Please enter Account Number")
                return
            }

            if(ifscCode.isEmpty()) {
                UtilFunctions.showToast(mContext, "Please enter IFSC Code")
                return
            }

            if(bankName.isEmpty()) {
                UtilFunctions.showToast(mContext, "Please enter Bank Name")
                return
            }
        }

        val withdrawAmountData = WithdrawAmountData()

        withdrawAmountData.amount=amount
        withdrawAmountData.mode=selWithDrawMode
        withdrawAmountData.upiId=upiId
        withdrawAmountData.accHolderName=accHolderName
        withdrawAmountData.accNumber=accNumber
        withdrawAmountData.ifsccode=ifscCode
        withdrawAmountData.bankName=bankName

        onSubmitClicked.invoke(withdrawAmountData)

    }


    private fun radioButtonListeners()
    {
        binding.rgWithdraw.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.ggUPIID.id -> {
                    selWithDrawMode=1
                    binding.upiidLt.visibility = View.VISIBLE
                    binding.bankDetailsLt.visibility=View.GONE
                }

                binding.ggBankDetails.id -> {
                    selWithDrawMode=2
                    binding.upiidLt.visibility = View.GONE
                    binding.bankDetailsLt.visibility=View.VISIBLE
                }
            }
        }
    }

    fun openWithdrawlDialog() {
        messageBoxInstance.show()
    }

    private fun closeWithdrawlDialog() {
        messageBoxInstance.dismiss()
    }

}