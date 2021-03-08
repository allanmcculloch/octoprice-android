package com.octoprice.android.ui.industry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octoprice.android.domain.usecase.GetGridSupplyPointsUseCase
import kotlinx.coroutines.launch

class IndustryViewModel(private val gridSupplyPointsUseCase: GetGridSupplyPointsUseCase) :
    ViewModel() {

    val postCode: MutableLiveData<String> = MutableLiveData()

    private val _gridSupplyPoint = MutableLiveData<String>()
    val gridSupplyPoint: LiveData<String> = _gridSupplyPoint

    fun search() {
        val postCode = postCode.value ?: return

        viewModelScope.launch {
            val groups = gridSupplyPointsUseCase(postCode).groups

            if (!groups.isNullOrEmpty()) {
                _gridSupplyPoint.value = "$postCode is in group $groups"
            } else {
                _gridSupplyPoint.value = "$postCode is unknown"
            }

        }
    }
}