package com.org.livemarket.zAPIEndPoints

import com.org.livemarket.loginModule.modalClass.GetRepresentativeResponse
import com.org.livemarket.loginModule.modalClass.LoginResponse
import com.org.livemarket.loginModule.modalClass.UpdateLoginStatusResponse
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


}