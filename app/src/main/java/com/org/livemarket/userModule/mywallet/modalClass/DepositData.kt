package com.org.livemarket.userModule.mywallet.modalClass

import com.google.gson.annotations.SerializedName


data class DepositData(
    @SerializedName("Id")
    var depositId: Int = 0,
    @SerializedName("Amount")
    var amount: String = "",
    @SerializedName("ReferenceNo")
    var referenceNo: String = "",
    @SerializedName("Date")
    var date: String = "",
    @SerializedName("Status")
    var status: String = "",
    @SerializedName("UserId")
    var userId: Int = 0,
    @SerializedName("UserName")
    var userName: String = "",
    @SerializedName("PhoneNumber")
    var phoneNumber: String = ""

)