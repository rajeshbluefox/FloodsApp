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
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("appLogin.php")
    suspend fun postUserNameandPassword(
        @Field("MobileNo") phoneNo: String,
        @Field("Password") password: String,
    ): LoginResponse

    @FormUrlEncoded
    @POST("updateLoginStatus.php")
    suspend fun updateLoginStatus(
        @Field("TM_UM_ID") empId: Int,
        @Field("UM_ApproveStatus") status: Int,
    ): UpdateLoginStatusResponse

    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun getRepresentativeList(
        @Field("RepId") repId: Int,
    ): GetRepresentativeResponse

    //This app APIs

    //User Competition Section
    @GET("getMedRep.php")
    suspend fun getLiveCompetitions(
    ): GetLiveCompetitionsResponse

    //TODO API to get available tickets

    //API to purchase tickets
    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun purchaseTickets(
        @Field("UserId") userId: Int,
        @Field("Tickets") tickets: ArrayList<String>
    ): PurchaseTicketsResponse

    //User Wallet Section
    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun addDeposit(
        @Field("UserId") userId: Int,
        @Field("ReferenceId") referenceId: String,
        @Field("Amount") amount: String
    ): AddDepositResponse

    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun getDeposits(
        @Field("UserId") userId: Int
    ): GetDepositsResponse

    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun requestWithdraw(
        @Field("UserId") userId: Int,
        @Field("Amount") amount: String,
        @Field("Mode") mode: Int,
        @Field("UPIId") upiId: String,
        @Field("AccHolderName") accHolderName: String,
        @Field("AccNumber") accNumber: String,
        @Field("IFSCCode") ifscCode: String,
        @Field("BankName") bankName: String
    ): RequestWithdrawResponse

    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun getWithdrawls(
        @Field("UserId") userId: Int
    ): GetWithdrawlResponse

    //My Lottries Section
    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun getMyCompetitions(
        @Field("UserId") userId: Int
    ): GetLiveCompetitionsResponse

    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun getPurchasedTickets(
        @Field("UserId") userId: Int,
        @Field("CompetitionId") competitionId: Int
    ): GetPurchasedTicketsResponse

    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun updatePassword(
        @Field("UserId") userId: Int,
        @Field("Password") password: String
    ): GetUpdatePasswordResponse

    //Admin APIs
    @FormUrlEncoded
    @POST("getMedRep.php")
    suspend fun getCompetitions(
        @Field("CompetitionType") competitionId: Int
    ): GetLiveCompetitionsResponse


}