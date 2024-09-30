package com.org.livemarket.loginModule.modalClass

import com.google.gson.annotations.SerializedName



data class RepresentativeData(
    @SerializedName("RepId")
    var RepId: Int? = null,
    @SerializedName("RepCode")
    var RepCode: Int? = null,
    @SerializedName("RepName")
    var RepName: String ,
    @SerializedName("RepType")
    var RepType: Int? = null,
    @SerializedName("Landmark")
    var Landmark: String = "",
    @SerializedName("ContactNumber")
    var ContactNumber: String  ="",
    @SerializedName("Photo")
    var photo: String = ""

)