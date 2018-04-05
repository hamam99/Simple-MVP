package com.code_breaker.mvp.db_room

import android.util.Log
import com.code_breaker.mvp.db_room.db.RoomContract
import com.code_breaker.mvp.db_room.db.RoomDb
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RoomInteractor(var presenter: RoomContract.Presenter, var dao: RoomDb?) : RoomContract.Interactor {

    private val disposables: CompositeDisposable = CompositeDisposable()


    override fun loadAll() {
        dao?.bookDao()?.getAll
                ?.observeOn(Schedulers.io())
                ?.subscribeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ roomMdl ->
                    presenter?.loadAllSuccess(roomMdl)
                    presenter?.onSuccess("All data loaded!")
                }, { throwable ->
                    throwable.printStackTrace()
                    presenter.onError(throwable.localizedMessage)
                })
    }

    override fun insert(roomMdl: RoomMdl) {
        Log.e("TAG", " I am on interactor! 1")

        if (!roomMdl.author.isNullOrBlank() || !roomMdl.publisher.isNullOrBlank() || !roomMdl.title.isNullOrBlank()) {
            Observable.just(roomMdl)
                    .observeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe({ roomMdl ->
                        dao?.bookDao()?.insert(roomMdl)
                        presenter.insertSuccess("Insert Success!!!")
                    }, { throwable ->
                        throwable.printStackTrace()
                        presenter.onError(throwable.localizedMessage)
                    })
            Log.e("TAG", " I am on interactor! 2")
        } else {
            presenter.onError("masih ada yang kosong!")
            Log.e("TAG", " I am on interactor! 3")
        }
//        presenter.onSearchSuccess("Room interactor was here")

    }

    override fun search(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}