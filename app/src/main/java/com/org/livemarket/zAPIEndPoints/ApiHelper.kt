package com.org.livemarket.zAPIEndPoints

import com.org.livemarket.loginModule.modalClass.GetPharmaciesResponse
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

interface ApiHelper {

    suspend fun postUserNameandPassword(userName: String, password: String): LoginResponse

    suspend fun updateLoginStatus(empId: Int, status: Int): UpdateLoginStatusResponse

    suspend fun getRepresentativesList(repId: Int): GetRepresentativeResponse

    //This APIs
    suspend fun getLiveCompetitionsList(): GetLiveCompetitionsResponse

    suspend fun purchaseTickets(userId: Int,ticketsList:ArrayList<String>): PurchaseTicketsResponse

    suspend fun addDeposit(depositData: DepositData): AddDepositResponse

    suspend fun requestWithdraw(withdrawData: WithdrawAmountData): RequestWithdrawResponse

    suspend fun getDepositsList(userId: Int): GetDepositsResponse

    suspend fun getWithdrawalsList(userId: Int): GetWithdrawlResponse

    suspend fun getMyCompetitions(userId: Int): GetLiveCompetitionsResponse

    suspend fun getPurchasedTickets(userId: Int,competitionId: Int): GetPurchasedTicketsResponse

    suspend fun getUpdatedPassword(userId: Int,password: String): GetUpdatePasswordResponse

    //Admin API
    suspend fun getCompetitionsList(competitionType: Int): GetLiveCompetitionsResponse


}