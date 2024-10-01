package com.org.livemarket.userModule.mywallet.modalClass

import com.google.gson.annotations.SerializedName


data class WithdrawAmountData(
    @SerializedName("Id")
    var withDrawId: Int = 0,
    @SerializedName("Amount")
    var amount: String = "",
    @SerializedName("Mode")
    var mode: Int = 0,
    @SerializedName("upiid")
    var upiId: String = "",
    @SerializedName("AccHolderName")
    var accHolderName: String = "",
    @SerializedName("AccNumber")
    var accNumber: String = "",
    @SerializedName("IFSCCode")
    var ifsccode: String = "",
    @SerializedName("BankName")
    var bankName: String = "",
    @SerializedName("Date")
    var date: String = "",
    @SerializedName("Status")
    var status: Int = 0,
    @SerializedName("UserId")
    var userId: Int = 0,
    @SerializedName("UserName")
    var userName: String = "",
    @SerializedName("PhoneNumber")
    var phoneNumber: String =  ""

)