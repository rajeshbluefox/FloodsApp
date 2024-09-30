package com.org.livemarket.zAPIEndPoints

import com.org.livemarket.loginModule.modalClass.GetPharmaciesResponse
import com.org.livemarket.loginModule.modalClass.GetRepresentativeResponse
import com.org.livemarket.loginModule.modalClass.LoginResponse
import com.org.livemarket.loginModule.modalClass.UpdateLoginStatusResponse

interface ApiHelper {

    suspend fun postUserNameandPassword(userName: String, password: String): LoginResponse

    suspend fun updateLoginStatus(empId: Int, status: Int): UpdateLoginStatusResponse

    suspend fun getRepresentativesList(repId: Int): GetRepresentativeResponse


}