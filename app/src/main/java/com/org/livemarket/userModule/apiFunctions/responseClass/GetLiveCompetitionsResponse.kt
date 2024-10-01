package com.org.livemarket.userModule.apiFunctions.responseClass

import com.google.gson.annotations.SerializedName
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData


data class GetLiveCompetitionsResponse (
    @SerializedName("code")
    val code: Int = -1,
    @SerializedName("CompetitionsList")
    val competitionsList :  ArrayList<CompetitionData> = ArrayList()
)