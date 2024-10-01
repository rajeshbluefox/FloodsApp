package com.org.livemarket.adminModule.apiFunctions

import com.org.livemarket.userModule.apiFunctions.responseClass.GetLiveCompetitionsResponse
import com.org.livemarket.zAPIEndPoints.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AdminRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    private var getCompetitionsResponse = GetLiveCompetitionsResponse()

    suspend fun getCompetitions(competitionType: Int): GetLiveCompetitionsResponse {
        try {
            withContext(Dispatchers.IO) {
                getCompetitionsResponse = apiHelper.getCompetitionsList(competitionType)
            }
        } catch (_: Exception) {
        }
        return getCompetitionsResponse
    }

}