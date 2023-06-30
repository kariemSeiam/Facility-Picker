package com.radiusagent.facilitypicker.ui.facilities

import com.radiusagent.facilitypicker.data.local.models.Facility

interface FacilityContract {
    interface View {
        fun showFacilities(facilities: List<Facility>)
    }

    interface Presenter {
        fun fetchFacilities()
    }
}
