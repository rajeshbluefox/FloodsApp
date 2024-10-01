package com.org.livemarket.userModule.apiFunctions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private var getLiveCompetitionsResponse = MutableLiveData<GetLiveCompetitionsResponse>()

    fun getLiveCompetitions() {
        viewModelScope.launch {
            getLiveCompetitionsResponse.postValue(userRepository.getLiveCompetitions())
        }
    }

    fun resetGetLiveCompetitions() {
        getLiveCompetitionsResponse = MutableLiveData<GetLiveCompetitionsResponse>()
    }

    fun getLiveCompetitionsResponse(): LiveData<GetLiveCompetitionsResponse> {
        return getLiveCompetitionsResponse
    }

    private var purchaseTicketsResponse = MutableLiveData<PurchaseTicketsResponse>()

    fun purchaseTickets(userId: Int, tickets: ArrayList<String>) {
        viewModelScope.launch {
            purchaseTicketsResponse.postValue(userRepository.purchaseTickets(userId, tickets))
        }
    }


    fun resetPurchaseTickets() {
        purchaseTicketsResponse = MutableLiveData<PurchaseTicketsResponse>()
    }

    fun purchaseTicketsResponse(): LiveData<PurchaseTicketsResponse> {
        return purchaseTicketsResponse
    }

    private var addDepositResponse = MutableLiveData<AddDepositResponse>()

    fun addDeposit(depositData: DepositData) {
        viewModelScope.launch {
            addDepositResponse.postValue(userRepository.addDepositResponse(depositData))
        }
    }

    fun resetAddDepositResponse() {
        addDepositResponse = MutableLiveData<AddDepositResponse>()
    }

    fun addDepositResponse(): LiveData<AddDepositResponse> {
        return addDepositResponse
    }

    private var requestWithdrawResponse = MutableLiveData<RequestWithdrawResponse>()

    fun requestWithdraw(withdrawAmountData: WithdrawAmountData) {
        viewModelScope.launch {
            requestWithdrawResponse.postValue(userRepository.requestWithdraw(withdrawAmountData))
        }
    }

    fun resetRequestWithdrawResponse() {
        requestWithdrawResponse = MutableLiveData<RequestWithdrawResponse>()
    }

    fun requestWithdrawResponse(): LiveData<RequestWithdrawResponse> {
        return requestWithdrawResponse
    }

    private var getDepositsResponse = MutableLiveData<GetDepositsResponse>()

    fun getDeposits(userId: Int) {
        viewModelScope.launch {
            getDepositsResponse.postValue(userRepository.getDepositsResponse(userId))
        }
    }

    fun resetGetDepositsResponse() {
        getDepositsResponse = MutableLiveData<GetDepositsResponse>()
    }

    fun getDepositsResponse(): LiveData<GetDepositsResponse> {
        return getDepositsResponse
    }

    private var getWithdrawlResponse = MutableLiveData<GetWithdrawlResponse>()

    fun getWithdrawls(userId: Int) {
        viewModelScope.launch {
            getWithdrawlResponse.postValue(userRepository.getWithdrawResponse(userId))
        }
    }

    fun resetGetWithdrawlsResponse() {
        getWithdrawlResponse = MutableLiveData<GetWithdrawlResponse>()
    }

    fun getWithdrawlsResponse(): LiveData<GetWithdrawlResponse> {
        return getWithdrawlResponse
    }

    private var getMyCompetitionsResponse = MutableLiveData<GetLiveCompetitionsResponse>()

    fun getMyCompetitions(userId: Int) {
        viewModelScope.launch {
            getMyCompetitionsResponse.postValue(userRepository.getMyCompetitions(userId))
        }
    }

    fun resetGetMyCompetitions() {
        getMyCompetitionsResponse = MutableLiveData<GetLiveCompetitionsResponse>()
    }

    fun getMyCompetitionsResponse(): LiveData<GetLiveCompetitionsResponse> {
        return getMyCompetitionsResponse
    }

    private var getPurchasedTicketsResponse = MutableLiveData<GetPurchasedTicketsResponse>()

    fun getPurchasedTickets(userId: Int,competitionId:Int) {
        viewModelScope.launch {
            getPurchasedTicketsResponse.postValue(userRepository.getPurchasedTickets(userId,competitionId))
        }
    }

    fun resetGetPurchasedTickets() {
        getPurchasedTicketsResponse = MutableLiveData<GetPurchasedTicketsResponse>()
    }

    fun getPurchasedTicketsResponse(): LiveData<GetPurchasedTicketsResponse> {
        return getPurchasedTicketsResponse
    }

    private var getUpdatePasswordResponse = MutableLiveData<GetUpdatePasswordResponse>()

    fun getUpdatedPassword(userId: Int,password:String) {
        viewModelScope.launch {
            getUpdatePasswordResponse.postValue(userRepository.getUpdatedPassword(userId,password))
        }
    }

    fun resetGetUpdatedPassword() {
        getUpdatePasswordResponse = MutableLiveData<GetUpdatePasswordResponse>()
    }

    fun getUpdatedPasswordResponse(): LiveData<GetUpdatePasswordResponse> {
        return getUpdatePasswordResponse
    }


}