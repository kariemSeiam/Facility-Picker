package com.radiusagent.facilitypicker.data.local.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Option(
    @PrimaryKey
    var id: String = "",
    var name: String = "",
    var icon: String = ""
) : RealmObject()
