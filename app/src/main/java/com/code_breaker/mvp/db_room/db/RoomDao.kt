package com.code_breaker.mvp.db_room.db

import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * Created by akira on 26/03/18.
 */

@Dao
interface RoomDao {

    @get:Query("SELECT * FROM book")
    val getAll: Flowable<List<RoomMdl>>

    @Query("SELECT * from book order by id DESC limit 1")
    fun getLatest(): Flowable<RoomMdl>

    @Query("SELECT * from book where title LIKE :title")
    fun search(title: String): Flowable<List<RoomMdl>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: RoomMdl)

    @Update
    fun update(mdl: RoomMdl)

    @Delete
    fun delete(mdl: RoomMdl)

    @Query("delete from book")
    fun deleteAll()
}
