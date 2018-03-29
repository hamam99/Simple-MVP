package com.code_breaker.mvp.db_room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(RoomMdl::class), version = 1)
abstract class RoomDb : RoomDatabase() {
    abstract fun bookDao(): RoomDao


    private var INSTANCE: RoomDb? = null
    fun getAppDatabase(context: Context): RoomDb {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RoomDb::class.java!!, "user-database")
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build()
        }
        return INSTANCE as RoomDb
    }

    fun destroyInstance() {
        INSTANCE = null
    }


}