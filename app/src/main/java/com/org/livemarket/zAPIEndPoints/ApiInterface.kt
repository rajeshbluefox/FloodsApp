package com.org.livemarket.zAPIEndPoints

import com.org.livemarket.loginModule.modalClass.GetRepresentativeResponse
import com.org.livemarket.loginModule.modalClass.LoginResponse
import com.org.livemarket.loginModule.modalClass.UpdateLoginStatusResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
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


}