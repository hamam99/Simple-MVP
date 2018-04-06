package com.code_breaker.mvp.db_room

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomInteractor(var presenter: RoomContract.Presenter) : RoomContract.Interactor {
    override fun loadLatest() {
        presenter?.getDb()?.bookDao()?.getLatest()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ roomMdl ->
                    presenter?.loadLatestSuccess(roomMdl)
                    presenter?.onSuccess("Load latest success!")
                }, { throwable ->
                    throwable.printStackTrace()
                    presenter.onError(throwable.localizedMessage)
                })
    }

//    private val disposables: CompositeDisposable = CompositeDisposable()


    override fun loadAll() {
        Log.e("TAG", "Interactor : Load All 1")
        presenter?.getDb()?.bookDao()?.getAll
//                ?.subscribeOn(AndroidSchedulers.mainThread())
//                ?.observeOn(Schedulers.io())
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ roomMdl ->
                    presenter?.loadAllSuccess(roomMdl)
                    presenter?.onSuccess("All data loaded!")
                    Log.e("TAG", "Interactor : Load All 2")
                }, { throwable ->
                    throwable.printStackTrace()
                    presenter.onError(throwable.localizedMessage)
                    Log.e("TAG", "Interactor : Load All 3")
                })
    }

    override fun insert(roomMdl: RoomMdl) {
//        Log.e("TAG", " I am on interactor! 1")

        if (!roomMdl.author.isNullOrBlank() || !roomMdl.publisher.isNullOrBlank() || !roomMdl.title.isNullOrBlank()) {
            Observable.just(roomMdl)
//                    .observeOn(Schedulers.io())
//                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ roomMdl ->
                        presenter?.getDb()?.bookDao()?.insert(roomMdl)
                        presenter.insertSuccess("Insert Success!!!")
                        loadLatest()
                    }, { throwable ->
                        throwable.printStackTrace()
                        presenter.onError(throwable.localizedMessage)
                    })
//            Log.e("TAG", " I am on interactor! 2")
        } else {
            presenter.onError("masih ada yang kosong!")
//            Log.e("TAG", " I am on interactor! 3")
        }
//        presenter.onSearchSuccess("Room interactor was here")

    }

    override fun search(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}