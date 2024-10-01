package com.org.livemarket.userModule.apiFunctions.responseClass

import com.google.gson.annotations.SerializedName


data class RequestWithdrawResponse (
    @SerializedName("code")
    val code: Int = -1,
    @SerializedName("message")
    val message: String = ""
)