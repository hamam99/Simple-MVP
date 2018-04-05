package com.code_breaker.mvp.db_room

import android.util.Log
import com.code_breaker.mvp.db_room.db.RoomContract
import com.code_breaker.mvp.db_room.db.RoomDb

class RoomPresenter(var roomDb: RoomDb): RoomContract.Presenter {

//    var roomDb: RoomDb? = null

    var view: RoomContract.View? = null

    override fun setDb(db: RoomDb) {
//        roomDb = db
    }

    override fun getDb(): RoomDb? {
//        return roomDb
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var interactor = RoomInteractor(this,roomDb)

    override fun onSuccess(message: String) {
        view?.onSuccess(message)
    }

    override fun onError(message: String) {
        view?.onError(message)
        Log.e("TAG"," I am on Error! 1")

    }

    override fun searchSuccess(rooms: List<RoomMdl>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun loadAll() {
        interactor?.loadAll()
    }

    override fun loadAllSuccess(rooms: List<RoomMdl>) {
        view?.loadAll(rooms)
    }


    override fun insert(roomMdl: RoomMdl) {
        Log.e("TAG"," I am on insert! 1")

        interactor.insert(roomMdl)
    }

    override fun insertSuccess(message: String) {
        view?.insertSuccess(message)
    }


    override fun search(title: String) {
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