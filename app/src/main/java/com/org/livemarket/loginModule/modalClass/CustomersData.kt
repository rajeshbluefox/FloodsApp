package com.org.livemarket.loginModule.modalClass

import com.google.gson.annotations.SerializedName


data class CustomersData(
    @SerializedName("CustomerId")
    var customerId: Int = 0,
    @SerializedName("CustomerName")
    var customerName: String = "",
    @SerializedName("ServerURL")
    var serverURL: String = "",
    @SerializedName("LoopByteURL")
    var loopByteURL: String = "",
    @SerializedName("BFSURL")
    var bfsURL: String = ""
)