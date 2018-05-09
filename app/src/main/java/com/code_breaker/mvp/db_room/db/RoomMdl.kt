package com.code_breaker.mvp.db_room.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by akira on 26/03/18.
 */

@Entity(tableName = "book")
class RoomMdl {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "title")
    var title: String? = null

    @ColumnInfo
    var author: String? = null

    @ColumnInfo
    var publisher: String? = null

//    @ColumnInfo
//    private val date: String? = null
//
//    @ColumnInfo
//    private val description: String? = null

//    @ColumnInfo
//    private val cover: String? = null


}
