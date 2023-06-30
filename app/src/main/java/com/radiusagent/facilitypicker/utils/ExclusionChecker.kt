package com.radiusagent.facilitypicker.utils

import com.radiusagent.facilitypicker.data.local.models.Facility

object ExclusionChecker {
    fun getExcludedOptions(
        selectedFacilityId: String,
        selectedOptionIds: List<String>
    ): List<Facility> {
        // Implement exclusion logic here
        return emptyList()
    }
}
