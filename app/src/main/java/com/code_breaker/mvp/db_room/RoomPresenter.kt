package com.code_breaker.mvp.db_room

import io.reactivex.Flowable

class RoomPresenter : RoomContract.Presenter {

    var view: RoomContract.View? = null

    override fun loadAll(): Flowable<List<RoomMdl>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(roomMdl: RoomMdl) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun search(title: String): Flowable<List<RoomMdl>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(roomMdl: RoomMdl) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAttach(view: RoomContract.View) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

}