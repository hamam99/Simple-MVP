package com.code_breaker.mvp.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class RealmMdl : RealmObject() {
    @PrimaryKey
    public var id: String?=UUID.randomUUID().toString();

//    public var id: String = UUID.randomUUID().toString();
    public var title: String? = null

    public var author: String? = null

    public var publisher: String? = null
}