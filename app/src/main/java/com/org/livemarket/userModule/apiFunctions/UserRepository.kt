package com.org.livemarket.userModule.apiFunctions

import com.org.livemarket.userModule.apiFunctions.responseClass.AddDepositResponse
import com.org.livemarket.userModule.apiFunctions.responseClass.GetDepositsResponse
import com.org.livemarket.userModule.apiFunctions.responseClass.GetLiveCompetitionsResponse
import com.org.livemarket.userModule.apiFunctions.responseClass.GetPurchasedTicketsResponse
import com.org.livemarket.userModule.apiFunctions.responseClass.GetUpdatePasswordResponse
import com.org.livemarket.userModule.apiFunctions.responseClass.GetWithdrawlResponse
import com.org.livemarket.userModule.apiFunctions.responseClass.PurchaseTicketsResponse
import com.org.livemarket.userModule.apiFunctions.responseClass.RequestWithdrawResponse
import com.org.livemarket.userModule.mywallet.modalClass.DepositData
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData
import com.org.livemarket.zAPIEndPoints.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    private var getLiveCompetitionsResponse = GetLiveCompetitionsResponse()

    suspend fun getLiveCompetitions(): GetLiveCompetitionsResponse {
        try {
            withContext(Dispatchers.IO) {
                getLiveCompetitionsResponse = apiHelper.getLiveCompetitionsList()
            }
        } catch (_: Exception) {
        }
        return getLiveCompetitionsResponse
    }

    private var purchaseTicketsResponse = PurchaseTicketsResponse()

    suspend fun purchaseTickets(userId: Int, tickets: ArrayList<String>): PurchaseTicketsResponse {
        try {
            withContext(Dispatchers.IO) {
                purchaseTicketsResponse = apiHelper.purchaseTickets(userId, tickets)
            }
        } catch (_: Exception) {
        }
        return purchaseTicketsResponse
    }

    private var addDepositResponse = AddDepositResponse()

    suspend fun addDepositResponse(depositData: DepositData): AddDepositResponse {
        try {
            withContext(Dispatchers.IO) {
                addDepositResponse = apiHelper.addDeposit(depositData)
            }
        } catch (_: Exception) {
        }
        return addDepositResponse
    }

    private var requestWithdrawResponse = RequestWithdrawResponse()

    suspend fun requestWithdraw(withdrawAmountData: WithdrawAmountData): RequestWithdrawResponse {
        try {
            withContext(Dispatchers.IO) {
                requestWithdrawResponse = apiHelper.requestWithdraw(withdrawAmountData)
            }
        } catch (_: Exception) {
        }
        return requestWithdrawResponse
    }

    private var getDepositsResponse = GetDepositsResponse()

    suspend fun getDepositsResponse(userId: Int): GetDepositsResponse {
        try {
            withContext(Dispatchers.IO) {
                getDepositsResponse = apiHelper.getDepositsList(userId)
            }
        } catch (_: Exception) {
        }
        return getDepositsResponse
    }

    private var getWithdrawlResponse = GetWithdrawlResponse()

    suspend fun getWithdrawResponse(userId: Int): GetWithdrawlResponse {
        try {
            withContext(Dispatchers.IO) {
                getWithdrawlResponse = apiHelper.getWithdrawalsList(userId)
            }
        } catch (_: Exception) {
        }
        return getWithdrawlResponse
    }

    private var getMyCompetitionsResponse = GetLiveCompetitionsResponse()

    suspend fun getMyCompetitions(userId: Int): GetLiveCompetitionsResponse {
        try {
            withContext(Dispatchers.IO) {
                getMyCompetitionsResponse = apiHelper.getMyCompetitions(userId)
            }
        } catch (_: Exception) {
        }
        return getMyCompetitionsResponse
    }

    private var getPurchasedTicketsResponse = GetPurchasedTicketsResponse()

    suspend fun getPurchasedTickets(userId: Int, competitionId: Int): GetPurchasedTicketsResponse {
        try {
            withContext(Dispatchers.IO) {
                getPurchasedTicketsResponse = apiHelper.getPurchasedTickets(userId, competitionId)
            }
        } catch (_: Exception) {
        }
        return getPurchasedTicketsResponse
    }

    private var getUpdatePasswordResponse = GetUpdatePasswordResponse()

    suspend fun getUpdatedPassword(userId: Int, password: String): GetUpdatePasswordResponse {
        try {
            withContext(Dispatchers.IO) {
                getUpdatePasswordResponse = apiHelper.getUpdatedPassword(userId, password)
            }
        } catch (_: Exception) {
        }
        return getUpdatePasswordResponse
    }

}