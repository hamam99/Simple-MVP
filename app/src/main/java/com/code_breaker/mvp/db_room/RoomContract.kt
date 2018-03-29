package com.code_breaker.mvp.db_room

import com.code_breaker.mvp.base.BasePresenter
import com.code_breaker.mvp.base.BaseView
import io.reactivex.Flowable

/**
 * Created by akira on 26/03/18.
 */

interface RoomContract {
    interface View : BaseView {
        fun loadAll(rooms: List<RoomMdl>)
        fun search(rooms: List<RoomMdl>)
        fun insert()
        fun clearScreen()
        fun delete()

        fun onSuccess(message: String)
        fun onError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun loadAll()
        fun insert(roomMdl: RoomMdl)
        fun search(title: String): Flowable<List<RoomMdl>>
        fun searchSuccess(rooms:List<RoomMdl>)
        fun delete(roomMdl: RoomMdl)

        fun onSuccess(message: String)
        fun onError(message: String)
    }

    interface Interactor {
        fun loadAll()
        fun insert(roomMdl: RoomMdl)
        fun search(title: String)

    }
}
