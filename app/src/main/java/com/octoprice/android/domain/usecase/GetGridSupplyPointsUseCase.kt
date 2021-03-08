package com.octoprice.android.domain.usecase

import com.octoprice.android.repository.IndustryRepository

class GetGridSupplyPointsUseCase(private val industryRepository: IndustryRepository) {
    suspend operator fun invoke(postCode: String) =
        industryRepository.getGridSupplyPoints(postCode)
}