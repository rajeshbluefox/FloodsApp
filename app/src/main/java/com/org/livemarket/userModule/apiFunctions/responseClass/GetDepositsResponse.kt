package com.org.livemarket.userModule.apiFunctions.responseClass

import com.google.gson.annotations.SerializedName
import com.org.livemarket.userModule.mywallet.modalClass.DepositData

data class GetDepositsResponse (
    @SerializedName("code")
    val code: Int = -1,
    @SerializedName("DepositsList")
    val depositsList :  ArrayList<DepositData> = ArrayList()
)