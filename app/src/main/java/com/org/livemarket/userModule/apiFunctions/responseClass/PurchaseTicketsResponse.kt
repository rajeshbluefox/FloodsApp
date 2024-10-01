package com.org.livemarket.userModule.apiFunctions.responseClass

import com.google.gson.annotations.SerializedName
import com.org.livemarket.userModule.competitions.modalClass.TicketData


data class PurchaseTicketsResponse (
    @SerializedName("code")
    val code: Int = -1,
    @SerializedName("PurchasedTicketsList")
    val purchasedTicketsList :  ArrayList<TicketData> = ArrayList(),
    @SerializedName("FailedTicketsList")
    val failedTicketsList :  ArrayList<TicketData> = ArrayList()
)