package com.org.livemarket.adminModule.blockUser.modalClass

import com.google.gson.annotations.SerializedName


data class UserData(
    @SerializedName("UserId")
    var userId: Int = 0,
    @SerializedName("UserName")
    var userName: String = "",
    @SerializedName("PhoneNumber")
    var phoneNumber: String = "",
    @SerializedName("Status")
    var status: Int = -1,
)