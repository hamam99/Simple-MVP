package com.code_breaker.mvp.db_room

import android.arch.persistence.room.Room
import android.content.Context

object RoomDbManager {
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