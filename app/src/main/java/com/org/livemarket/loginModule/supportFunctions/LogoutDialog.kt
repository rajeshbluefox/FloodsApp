package com.org.livemarket.loginModule.supportFunctions

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.org.livemarket.R


class LogoutDialog(
    layoutInflater: LayoutInflater,
    context: Context,
    private val listener: () -> Unit
) {

    private val mLayoutInflater: LayoutInflater
    private val mContext: Context

    private lateinit var dialog: AlertDialog.Builder
    private lateinit var messageBoxInstance: AlertDialog

    private lateinit var tvTitle : TextView

    init {
        mLayoutInflater = layoutInflater
        mContext = context

        initViews()
    }


    fun initViews() {
        val view = mLayoutInflater.inflate(R.layout.alert_logout, null)
        dialog = AlertDialog.Builder(mContext,R.style.CurvedDialog).setView(view)
        dialog.setCancelable(false)
        messageBoxInstance = dialog.create()

        val btYes = view.findViewById<TextView>(R.id.btYes)
        val btNo = view.findViewById<TextView>(R.id.btNo)

        tvTitle= view.findViewById(R.id.mainTitle)

        btNo.setOnClickListener {
            messageBoxInstance.dismiss()
        }

        btYes.setOnClickListener {
            listener.invoke()
        }
    }

    fun openLogoutDialog(title:String) {
        tvTitle.text=title
        messageBoxInstance.show()

    }

    fun dismissDialog()
    {
        messageBoxInstance.dismiss()

    }

}