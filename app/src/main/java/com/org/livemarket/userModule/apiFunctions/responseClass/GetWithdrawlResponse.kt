package com.org.livemarket.userModule.apiFunctions.responseClass

import com.google.gson.annotations.SerializedName
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData


data class GetWithdrawlResponse (
    @SerializedName("code")
    val code: Int = -1,
    @SerializedName("WithdrawalList")
    val withdrawalList :  ArrayList<WithdrawAmountData> = ArrayList()
)