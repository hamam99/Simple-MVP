package com.code_breaker.mvp.db_room

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomInteractor(var presenter: RoomContract.Presenter) : RoomContract.Interactor {

    override fun onUpdate(roomMdl: RoomMdl, position: Int) {
        if (!roomMdl.author.isNullOrBlank() || !roomMdl.publisher.isNullOrBlank() || !roomMdl.title.isNullOrBlank()) {
            Observable.just(roomMdl)
//                    .observeOn(Schedulers.io())
//                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ roomMdl ->
                        presenter?.getDb()?.bookDao()?.update(roomMdl)
                        presenter?.onUpdateSuccess(roomMdl, position)
                    }, { throwable ->
                        throwable.printStackTrace()
                        presenter.onError(throwable.localizedMessage)
                    })
        } else {
            presenter.onError("There are empty field")
        }
    }

    override fun delete(roomMdl: RoomMdl) {
        Observable.just(roomMdl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ roomMdl ->
                    presenter?.getDb()?.bookDao()?.delete(roomMdl)
                    presenter.onSuccess("Data had been deleted!")
                }, { throwable ->
                    throwable.printStackTrace()
                    presenter.onError(throwable.localizedMessage)
                })
    }

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
        presenter?.getDb()?.bookDao()?.getAll
//                ?.subscribeOn(AndroidSchedulers.mainThread())
//                ?.observeOn(Schedulers.io())
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ roomMdl ->
                    presenter?.loadAllSuccess(roomMdl)
                    presenter?.onSuccess("All data loaded!")
                }, { throwable ->
                    throwable.printStackTrace()
                    presenter.onError(throwable.localizedMessage)
                })
    }

    override fun insert(roomMdl: RoomMdl) {
        if (!roomMdl.author.isNullOrBlank() || !roomMdl.publisher.isNullOrBlank() || !roomMdl.title.isNullOrBlank()) {
            Observable.just(roomMdl)
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
        } else {
            presenter.onError("There are empty field")
        }

    }

    override fun search(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}