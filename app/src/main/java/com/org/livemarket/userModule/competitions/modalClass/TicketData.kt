package com.org.livemarket.userModule.competitions.modalClass

import com.google.gson.annotations.SerializedName


data class TicketData(
    @SerializedName("TicketId")
    var ticketId: Int? = null,
    @SerializedName("CompetitionId")
    var competitionId: Int? = null,
    @SerializedName("TicketNumber")
    var ticketNumber: String,
    @SerializedName("TicketPrice")
    var ticketPrice: String,
    @SerializedName("TicketStatus")
    var ticketStatus: String,

    )