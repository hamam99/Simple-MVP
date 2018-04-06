package com.code_breaker.mvp.db_room.db

import com.code_breaker.mvp.base.BasePresenter
import com.code_breaker.mvp.base.BaseView
import com.code_breaker.mvp.db_room.RoomMdl

/**
 * Created by akira on 26/03/18.
 */

interface RoomContract {
    interface View : BaseView {
        fun loadAll(rooms: List<RoomMdl>)
        fun search(rooms: List<RoomMdl>)
        fun insertSuccess(message:String)
        fun clearScreen()
        fun delete()

        fun onSuccess(message: String)
        fun onError(message: String)

        fun onAttachView()
        fun onDetachView()

    }

    interface Presenter : BasePresenter<View> {
        fun loadAll()
        fun loadAllSuccess(rooms:List<RoomMdl>)

        fun insert(roomMdl: RoomMdl)
        fun insertSuccess(message:String)

        fun search(title: String)
        fun searchSuccess(rooms:List<RoomMdl>)
        fun delete(roomMdl: RoomMdl)

        fun onSuccess(message: String)
        fun onError(message: String)

        fun setDb(db:RoomDb)
        fun getDb():RoomDb?

    }

    interface Interactor {
        fun loadAll()
        fun insert(roomMdl: RoomMdl)
        fun search(title: String)

    }
}
