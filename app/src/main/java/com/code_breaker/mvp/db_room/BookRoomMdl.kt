package com.code_breaker.mvp.db_room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by akira on 26/03/18.
 */

@Entity
class BookRoomMdl {
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    @ColumnInfo(name = "title")
    val title: String? = null

    @ColumnInfo
    val author: String? = null

    @ColumnInfo
    val publisher: String? = null

//    @ColumnInfo
//    private val date: String? = null
//
//    @ColumnInfo
//    private val description: String? = null

//    @ColumnInfo
//    private val cover: String? = null


}
