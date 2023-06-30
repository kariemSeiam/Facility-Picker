package com.radiusagent.facilitypicker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.radiusagent.facilitypicker.R
import com.radiusagent.facilitypicker.data.local.database.RealmManager
import com.radiusagent.facilitypicker.ui.facilities.FacilityFragment
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)
        RealmManager.initRealm()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FacilityFragment())
            .commit()
    }
}