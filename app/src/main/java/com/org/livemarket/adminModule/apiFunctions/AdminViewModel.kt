package com.org.livemarket.adminModule.apiFunctions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.livemarket.userModule.apiFunctions.responseClass.GetLiveCompetitionsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AdminViewModel @Inject constructor(
    private val adminRepository: AdminRepository
) : ViewModel() {

    private var getCompetitionsResponse = MutableLiveData<GetLiveCompetitionsResponse>()

    fun getCompetitions(competitionType: Int) {
        viewModelScope.launch {
            getCompetitionsResponse.postValue(adminRepository.getCompetitions(competitionType))
        }
    }

    fun resetGetCompetitions() {
        getCompetitionsResponse = MutableLiveData<GetLiveCompetitionsResponse>()
    }

    fun getCompetitionsResponse(): LiveData<GetLiveCompetitionsResponse> {
        return getCompetitionsResponse
    }

}