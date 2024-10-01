package com.org.livemarket.userModule.profileuser.modalClass

import com.google.gson.annotations.SerializedName


data class ChangePasswordData(
    @SerializedName("UserId")
    var userId: String = "",
    @SerializedName("newPassword")
    var newPassword: String = "",

    )