package com.org.livemarket.userModule.apiFunctions.responseClass

import com.google.gson.annotations.SerializedName
import com.org.livemarket.userModule.competitions.modalClass.TicketData


data class GetPurchasedTicketsResponse (
    @SerializedName("code")
    val code: Int = -1,
    @SerializedName("TicketsList")
    val ticketsList :  ArrayList<TicketData> = ArrayList()
)