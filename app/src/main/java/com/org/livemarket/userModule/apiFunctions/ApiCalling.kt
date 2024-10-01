package com.org.livemarket.userModule.apiFunctions

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData
import com.org.livemarket.userModule.competitions.modalClass.TicketData
import com.org.livemarket.userModule.mywallet.modalClass.DepositData
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData
import com.org.livemarket.zCommonFuntions.UtilFunctions

class ApiCalling(
    private val context: Context,
    private val lifecycleOwner: LifecycleOwner,
    private val userViewModel: UserViewModel,
    private val getLiveCompetitionsResponse: (competitionsList: ArrayList<CompetitionData>) -> Unit,
    private val purchaseTicketsResponse: (purchasedTickets: ArrayList<TicketData>, failedTickets: ArrayList<TicketData>) -> Unit,
    private val addDepositResponse: () -> Unit,
    private val requestWithdrawResponse: () -> Unit,
    private val getDepositsResponse: (depositsList: ArrayList<DepositData>) -> Unit,
    private val getWithdrawlsResponse: (withdrawlsList: ArrayList<WithdrawAmountData>) -> Unit,
    private val getMyCompetitionsResponse: (competitionsList: ArrayList<CompetitionData>) -> Unit,
    private val getPurchasedTicketsResponse: (purchasedTickets: ArrayList<TicketData>) -> Unit,
    private val updatePasswordResponse: (status:Boolean) -> Unit,
    ) {

    fun getLiveCompetitions() {
        userViewModel.resetGetLiveCompetitions()
        userViewModel.getLiveCompetitions()
        getLiveCompetitionsResponse()
    }

    private fun getLiveCompetitionsResponse() {
        userViewModel.getLiveCompetitionsResponse().observe(lifecycleOwner) {
            if (it.code != 195) {
                if (it.code == 200) {
//                    UtilFunctions.showToast(context, "Success")
                    getLiveCompetitionsResponse.invoke(it.competitionsList)

                } else {
                    UtilFunctions.showToast(context, "Failed to get response")
                }
            } else {
                UtilFunctions.showToast(context, "Something Went Wrong")
            }
        }

    }

    fun purchaseTickets(userId: Int, tickets: ArrayList<String>) {
        userViewModel.resetPurchaseTickets()
        userViewModel.purchaseTickets(userId, tickets)
        purchaseTicketsResponse()
    }

    private fun purchaseTicketsResponse() {
        userViewModel.purchaseTicketsResponse().observe(lifecycleOwner) {
            if (it.code != 195) {
                if (it.code == 200) {
                    purchaseTicketsResponse.invoke(it.purchasedTicketsList, it.failedTicketsList)
                } else {
                    UtilFunctions.showToast(context, "Failed to get response")
                }
            } else {
                UtilFunctions.showToast(context, "Something Went Wrong")
            }
        }
    }

    fun addDeposit(depositData: DepositData) {
        userViewModel.resetAddDepositResponse()
        userViewModel.addDeposit(depositData)
        addDepositResponse()
    }

    private fun addDepositResponse() {
        userViewModel.addDepositResponse().observe(lifecycleOwner) {
            if (it.code != 195) {
                if (it.code == 200) {
                    addDepositResponse.invoke()
                } else {
                    UtilFunctions.showToast(context, "Failed to get response")
                }

            } else {
                UtilFunctions.showToast(context, "Something Went Wrong")
            }
        }
    }

    fun requestWithdraw(withdrawAmountData: WithdrawAmountData)
    {
        userViewModel.resetRequestWithdrawResponse()
        userViewModel.requestWithdraw(withdrawAmountData)
        requestWithdrawResponse()
    }

    private fun requestWithdrawResponse()
    {
        userViewModel.requestWithdrawResponse().observe(lifecycleOwner){
            if(it.code!=195)
            {
                if(it.code==200)
                {
                    requestWithdrawResponse.invoke()
                    UtilFunctions.showToast(context,"Request Sent Successfully")
                }
                else{
                    UtilFunctions.showToast(context,"Failed to get response")
                }
            }else{
                UtilFunctions.showToast(context,"Something Went Wrong")
            }
        }
    }

    fun getDeposits(userId: Int)
    {
        userViewModel.resetGetDepositsResponse()
        userViewModel.getDeposits(userId)
        getDepositsResponse()
    }

    private fun getDepositsResponse()
    {
        userViewModel.getDepositsResponse().observe(lifecycleOwner){
            if(it.code!=195)
            {
                if(it.code==200)
                {
                    getDepositsResponse.invoke(it.depositsList)
                }
                else{
                    UtilFunctions.showToast(context,"Failed to get response")
                }
            }else{
                UtilFunctions.showToast(context,"Something Went Wrong")
            }
        }
    }

    fun getWithdraws(userId: Int)
    {
        userViewModel.resetGetWithdrawlsResponse()
        userViewModel.getWithdrawls(userId)
        getWithDrawsResponse()

    }

    private fun getWithDrawsResponse()
    {
        userViewModel.getWithdrawlsResponse().observe(lifecycleOwner){
            if(it.code!=195)
            {
                if(it.code==200)
                {
                    getWithdrawlsResponse.invoke(it.withdrawalList)
                }
                else{
                    UtilFunctions.showToast(context,"Failed to get response")
                }
            }else{
                UtilFunctions.showToast(context,"Something Went Wrong")
            }
        }
    }

    fun getMyCompetitions(userId: Int)
    {
        userViewModel.resetGetMyCompetitions()
        userViewModel.getMyCompetitions(userId)
        getMyCompetitionsObserver()
    }

    private fun getMyCompetitionsObserver()
    {
        userViewModel.getMyCompetitionsResponse().observe(lifecycleOwner){
            if(it.code!=195)
            {
                if(it.code==200)
                {
                    getMyCompetitionsResponse.invoke(it.competitionsList)
                }
                else{
                    UtilFunctions.showToast(context,"Failed to get response")
                }

            }else{
                UtilFunctions.showToast(context,"Something Went Wrong")
            }
        }
    }

    fun getPurchasedTickets(userId: Int,competitionId:Int)
    {
        userViewModel.resetGetPurchasedTickets()
        userViewModel.getPurchasedTickets(userId,competitionId)
        getPurchasedTicketsObserver()

    }

    private fun getPurchasedTicketsObserver() {
        userViewModel.getPurchasedTicketsResponse().observe(lifecycleOwner){
            if(it.code!=195)
            {
                if(it.code==200)
                {
                    getPurchasedTicketsResponse.invoke(it.ticketsList)
                }else{
                    UtilFunctions.showToast(context,"Failed to get response")
                }
            }else{
                UtilFunctions.showToast(context,"Something Went Wrong")
            }
        }
    }

    fun updatePassword(userId: Int,password:String)
    {
        userViewModel.resetGetUpdatedPassword()
        userViewModel.getUpdatedPassword(userId,password)
        updatePasswordResponse()
    }

    private fun updatePasswordResponse()
    {
        userViewModel.getUpdatedPasswordResponse().observe(lifecycleOwner){
            if(it.code!=195)
            {
                if(it.code==200)
                {
                    updatePasswordResponse.invoke(true)
                }else{
                    updatePasswordResponse.invoke(false)
                    UtilFunctions.showToast(context,"Failed to Update Password")
                }
            }else{
                UtilFunctions.showToast(context,"Something Went Wrong")
            }
        }
    }
}