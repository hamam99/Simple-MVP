package com.code_breaker.mvp.db_room

import com.code_breaker.mvp.base.BasePresenter
import com.code_breaker.mvp.base.BaseView

/**
 * Created by akira on 26/03/18.
 */

interface RoomContract {
    interface View : BaseView {
        fun loadAll(): BookRoomMdl
        fun search(title: String): BookRoomMdl
        fun insert(bookRoomMdl: BookRoomMdl)
        fun clear()

    }

    interface Presenter : BasePresenter<View> {
        fun loadAll(): BookRoomMdl
        fun insert(bookRoomMdl: BookRoomMdl)
        fun search(title: String): BookRoomMdl
    }

    interface Interactor {
        fun loadAll(): BookRoomMdl
        fun insert(bookRoomMdl: BookRoomMdl)
        fun search(title: String): BookRoomMdl

    }
}
