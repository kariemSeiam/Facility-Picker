package com.radiusagent.facilitypicker.data.local.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Facility(
    @PrimaryKey
    var id: String = "",
    var name: String = "",
    var options: RealmList<Option> = RealmList()
) : RealmObject()
