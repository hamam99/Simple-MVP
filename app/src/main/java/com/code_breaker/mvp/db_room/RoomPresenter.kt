package com.code_breaker.mvp.db_room

import android.util.Log
import com.code_breaker.mvp.db_room.db.RoomDb

class RoomPresenter(): RoomContract.Presenter {
    var roomDb: RoomDb? = null
    var view: RoomContract.View? = null
    var interactor = RoomInteractor(this)

    override fun setDb(db: RoomDb) {
        roomDb = db
    }

    override fun getDb(): RoomDb? {
        return roomDb
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(message: String) {
        view?.onSuccess(message)
    }

    override fun onError(message: String) {
        view?.onError(message)
    }

    override fun searchSuccess(rooms: List<RoomMdl>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun loadAll() {
        Log.e("TAG","Presenter : Load All 1")
        interactor?.loadAll()
    }

    override fun loadAllSuccess(rooms: List<RoomMdl>) {
        view?.loadAll(rooms)
        Log.e("TAG","Presenter : Load All 2")

    }


    override fun insert(roomMdl: RoomMdl) {
        interactor.insert(roomMdl)
    }

    override fun insertSuccess(message: String) {
        view?.insertSuccess(message)
    }


    override fun search(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(roomMdl: RoomMdl) {
        interactor?.delete(roomMdl)
    }

    override fun onAttach(view: RoomContract.View) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    override fun loadLatest() {
        interactor?.loadLatest()
    }

    override fun loadLatestSuccess(rooms: RoomMdl) {
        view?.loadLatest(rooms)
    }

    override fun onUpdate(roomMdl: RoomMdl) {
        interactor?.onUpdate(roomMdl)
    }
    override fun onUpdateSuccess(message: String) {
        view?.onUpdateSuccess(message)
    }


}