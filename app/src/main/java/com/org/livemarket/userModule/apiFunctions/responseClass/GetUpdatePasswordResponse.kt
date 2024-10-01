package com.org.livemarket.userModule.apiFunctions.responseClass

import com.google.gson.annotations.SerializedName

class GetUpdatePasswordResponse (
    @SerializedName("code")
    val code: Int = -1,
    @SerializedName("message")
    val message: String = ""
)
