package com.radiusagent.facilitypicker.data.remote.models

import com.radiusagent.facilitypicker.data.local.models.Facility

data class FacilityResponse(
    val facilities: List<Facility>,
    val exclusions: List<ExclusionCombination>
)
