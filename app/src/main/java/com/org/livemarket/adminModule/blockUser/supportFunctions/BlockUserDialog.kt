package com.org.livemarket.adminModule.blockUser.supportFunctions

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.org.livemarket.adminModule.blockUser.modalClass.UserData
import com.org.livemarket.databinding.DialogBlockBinding


class BlockUserDialog(
    layoutInflater: LayoutInflater,
    context: Context,
    private val onBlockClicked: (userDate: UserData,isBlocked: Boolean) -> Unit

) {
    private val mLayoutInflater: LayoutInflater
    private val mContext: Context

    private var binding: DialogBlockBinding
    private var dialog: AlertDialog.Builder
    private var messageBoxInstance: AlertDialog

    init {
        mLayoutInflater = layoutInflater
        mContext = context
        binding = DialogBlockBinding.inflate(mLayoutInflater)
        dialog = AlertDialog.Builder(mContext).setView(binding.root)
        dialog.setCancelable(true)
        messageBoxInstance = dialog.create()

    }

    fun openBlockUserDialog(
        userData: UserData,
        isBlocked: Boolean,
        title: String
    ) {
        binding.mainTitle.text = title

        messageBoxInstance.show()

        binding.btYes.setOnClickListener {
            onBlockClicked.invoke(userData,isBlocked)
        }
        binding.btNo.setOnClickListener {
            closeBlockUserDialog()
        }
    }

    private fun closeBlockUserDialog() {
        messageBoxInstance.dismiss()
    }

}