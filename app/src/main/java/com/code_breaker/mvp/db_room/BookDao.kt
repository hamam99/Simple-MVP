package com.code_breaker.mvp.db_room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

/**
 * Created by akira on 26/03/18.
 */

@Dao
interface BookDao {

    @get:Query("SELECT * FROM book")
    val getAll: List<BookRoomMdl>

    @Query("SELECT * from book where name LIKE :title")
    fun search(title: String): BookRoomMdl

    @Insert
    fun insert(book: BookRoomMdl)

    @Update
    fun update(bookMdl: BookRoomMdl)

    @Delete
    fun delete(bookMdl: BookRoomMdl)

}
