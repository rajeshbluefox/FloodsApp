package com.org.livemarket.userModule.competitions.modalClass

import com.google.gson.annotations.SerializedName


data class CompetitionData(
    @SerializedName("CompetitionId")
    var competitionId: Int = 0,
    @SerializedName("CompetitionName")
    var name: String = "",
    @SerializedName("CompetitionImage")
    var competitionImage: String = "",
    @SerializedName("StartRange")
    var startRange: String = "",
    @SerializedName("EndRange")
    var endRange: String = "",
    @SerializedName("TicketCost")
    var ticketCost: String = "",
    @SerializedName("WithDrawDate")
    var withDrawDate: String = "",
    @SerializedName("PricesCount")
    var prizeCount: String = "",
    @SerializedName("DateOfPosting")
    var dateOfPosting: String = ""
)