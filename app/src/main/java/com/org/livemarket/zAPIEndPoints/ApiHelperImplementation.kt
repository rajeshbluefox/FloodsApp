package com.org.livemarket.zAPIEndPoints

import com.org.livemarket.loginModule.modalClass.GetRepresentativeResponse
import com.org.livemarket.loginModule.modalClass.LoginResponse
import com.org.livemarket.loginModule.modalClass.UpdateLoginStatusResponse
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
import javax.inject.Inject


class ApiHelperImplementation @Inject constructor(private val apiService: ApiInterface) :
    ApiHelper {

    override suspend fun postUserNameandPassword(
        userName: String,
        password: String
    ): LoginResponse {
        return apiService.postUserNameandPassword(userName, password)
    }

    override suspend fun updateLoginStatus(
        empId: Int,
        status: Int
    ): UpdateLoginStatusResponse {
        return apiService.updateLoginStatus(empId, status)
    }


    override suspend fun getRepresentativesList(repId: Int): GetRepresentativeResponse {
        return apiService.getRepresentativeList(repId)
    }

    //This APIs

    override suspend fun getLiveCompetitionsList(): GetLiveCompetitionsResponse {
        return apiService.getLiveCompetitions()
    }

    override suspend fun purchaseTickets(
        userId: Int,
        ticketsList: ArrayList<String>
    ): PurchaseTicketsResponse {
        return apiService.purchaseTickets(userId, ticketsList)
    }

    override suspend fun addDeposit(depositData: DepositData): AddDepositResponse {
        return apiService.addDeposit(
            depositData.userId,
            depositData.referenceNo,
            depositData.amount
        )
    }

    override suspend fun requestWithdraw(withdrawData: WithdrawAmountData): RequestWithdrawResponse {
        return apiService.requestWithdraw(
            withdrawData.userId,
            withdrawData.amount,
            withdrawData.mode,
            withdrawData.upiId,
            withdrawData.accHolderName,
            withdrawData.accNumber,
            withdrawData.ifsccode,
            withdrawData.bankName
        )
    }

    override suspend fun getDepositsList(userId: Int): GetDepositsResponse {
        return apiService.getDeposits(userId)
    }

    override suspend fun getWithdrawalsList(userId: Int): GetWithdrawlResponse {
        return apiService.getWithdrawls(userId)
    }

    override suspend fun getMyCompetitions(userId: Int): GetLiveCompetitionsResponse {
        return apiService.getMyCompetitions(userId)
    }

    override suspend fun getPurchasedTickets(
        userId: Int,
        competitionId: Int
    ): GetPurchasedTicketsResponse {
        return apiService.getPurchasedTickets(userId, competitionId)
    }

    override suspend fun getUpdatedPassword(
        userId: Int,
        password: String
    ): GetUpdatePasswordResponse {
        return apiService.updatePassword(userId, password)
    }

    //Admin APIs
    override suspend fun getCompetitionsList(competitionType: Int): GetLiveCompetitionsResponse {
        return apiService.getCompetitions(competitionType)
    }


}