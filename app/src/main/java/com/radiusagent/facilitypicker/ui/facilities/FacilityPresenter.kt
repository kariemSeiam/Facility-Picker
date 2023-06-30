package com.radiusagent.facilitypicker.ui.facilities

import com.radiusagent.facilitypicker.data.local.database.RealmManager
import com.radiusagent.facilitypicker.data.local.models.Facility
import com.radiusagent.facilitypicker.data.remote.RetrofitClient
import com.radiusagent.facilitypicker.utils.ExclusionChecker
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class FacilityPresenter(private val view: FacilityContract.View) : FacilityContract.Presenter {

    private val disposables = CompositeDisposable()

    private fun saveDataToDatabase(facilities: List<Facility>) {
        val realm = RealmManager.getRealmInstance()

        realm.executeTransaction { realmInstance ->
            realmInstance.deleteAll()
        }
    }

    override fun fetchFacilities() {
        val apiService = RetrofitClient.create().getData()

        val disposable = apiService
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                val facilities = response.facilities
                val exclusions = response.exclusions

                // Perform exclusion checking
                val filteredFacilities = ExclusionChecker.getExcludedOptions(
                    selectedFacilityId = "",
                    selectedOptionIds = listOf()
                )

                // Save data to local database (Realm)
                saveDataToDatabase(filteredFacilities)

                // Display facilities in the view
                view.showFacilities(filteredFacilities)
            }, { throwable ->
                // Handle error
            })

        disposables.add(disposable)
    }
}


