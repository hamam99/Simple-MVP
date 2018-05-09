package com.code_breaker.mvp.db_room

import com.code_breaker.mvp.base.BasePresenter
import com.code_breaker.mvp.base.BaseView
import com.code_breaker.mvp.db_room.db.RoomDb
import com.code_breaker.mvp.db_room.db.RoomMdl

/**
 * Created by akira on 26/03/18.
 */

interface RoomContract {
    interface View : BaseView {
        fun loadAll(rooms: List<RoomMdl>)
        fun loadLatest(rooms: RoomMdl)
        fun search(rooms: List<RoomMdl>)
        fun insertSuccess(message: String)
        fun clearScreen()

        fun onSuccess(message: String)
        fun onError(message: String)

        fun onUpdateSuccess(item: RoomMdl, position: Int)

    }

    interface Presenter : BasePresenter<View> {
        fun loadAll()
        fun loadAllSuccess(rooms: List<RoomMdl>)

        fun insert(roomMdl: RoomMdl)
        fun insertSuccess(message: String)

        fun search(title: String)
        fun searchSuccess(rooms: List<RoomMdl>)

        fun delete(roomMdl: RoomMdl)

        fun onUpdate(item: RoomMdl, position: Int)
        fun onUpdateSuccess(item: RoomMdl, position: Int)

        fun onSuccess(message: String)
        fun onError(message: String)

        fun setDb(db: RoomDb)
        fun getDb(): RoomDb?

        fun loadLatest()
        fun loadLatestSuccess(rooms: RoomMdl)

    }

    interface Interactor {
        fun loadAll()
        fun insert(roomMdl: RoomMdl)
        fun search(title: String)
        fun loadLatest()
        fun delete(roomMdl: RoomMdl)
        fun onUpdate(item: RoomMdl, position: Int)
    }
}
