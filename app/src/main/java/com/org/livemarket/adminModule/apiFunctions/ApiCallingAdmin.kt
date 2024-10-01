package com.org.livemarket.adminModule.apiFunctions

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData
import com.org.livemarket.zCommonFuntions.UtilFunctions

class ApiCallingAdmin(
    private val context: Context,
    private val lifecycleOwner: LifecycleOwner,
    private val adminViewModel: AdminViewModel,
    private val getLiveCompetitionsResponse: (competitionsList: ArrayList<CompetitionData>) -> Unit,
    ) {
    fun getCompetitions(competitionType: Int) {
        adminViewModel.resetGetCompetitions()
        adminViewModel.getCompetitions(competitionType)
        getCompetitionsResponse()
    }

    private fun getCompetitionsResponse() {
        adminViewModel.getCompetitionsResponse().observe(lifecycleOwner) {
            if (it.code != 195) {
                if (it.code == 200) {
                    getLiveCompetitionsResponse.invoke(it.competitionsList)
                } else {
                    UtilFunctions.showToast(context, "Failed to get response")
                }
            }else{
                UtilFunctions.showToast(context, "Something Went Wrong")
            }
        }
    }
}