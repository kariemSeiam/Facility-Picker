package com.radiusagent.facilitypicker.data.local.database

import io.realm.Realm
import io.realm.RealmConfiguration

object RealmManager {
    private const val REALM_DB_NAME = "facility_picker.realm"
    private const val SCHEMA_VERSION = 1L

    fun initRealm() {
        val realmConfig = RealmConfiguration.Builder()
            .name(REALM_DB_NAME)
            .schemaVersion(SCHEMA_VERSION)
            .build()

        Realm.setDefaultConfiguration(realmConfig)
    }

    fun getRealmInstance(): Realm = Realm.getDefaultInstance()
}
