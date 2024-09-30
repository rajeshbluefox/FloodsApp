package com.org.livemarket.loginModule.modalClass

import com.google.gson.annotations.SerializedName


data class GetPharmaciesResponse (
    @SerializedName("code")
    val code: Int = -1,
    @SerializedName("PharmaCustomersList")
    val customersList :  ArrayList<CustomersData> = ArrayList()
)