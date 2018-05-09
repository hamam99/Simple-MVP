package com.code_breaker.mvp.db_room.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(RoomMdl::class), version = 1)
public abstract class RoomDb : RoomDatabase() {

    abstract fun bookDao(): RoomDao

    companion object {
        val dbName = "book_db"

        var INSTANCE: RoomDb? = null

        public fun getAppDatabase(context: Context): RoomDb {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, RoomDb::class.java!!, dbName)
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
}