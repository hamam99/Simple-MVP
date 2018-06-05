package com.code_breaker.mvp.realm

import android.util.Log
import io.realm.Realm
import io.realm.Realm.Transaction.OnError
import io.realm.Realm.Transaction.OnSuccess


class RealmInteractor(var mPresenter: RealmContract.Presenter) : RealmContract.Interactor {
    override fun insert(data: RealmMdl) {
        var realm = mPresenter?.mView?.getRealm()

        if (data?.author.isNullOrBlank() || data?.publisher.isNullOrBlank() || data?.title.isNullOrBlank()) {
            mPresenter?.onError("Masih ada yang  belum di isi!")
        } else {
            realm?.executeTransactionAsync(Realm.Transaction { bgRealm ->
                //                var dt= bgRealm.createObject(RealmMdl::class.java)
//                bgRealm.copyFromRealm(data)   //berat klo pake primary key
                bgRealm.insert(data)
                Log.e("TAG", "author : ${data.id}")
            }, OnSuccess {
                // Transaction was a success.
                mPresenter?.insertRes()
            }, OnError {
                mPresenter?.onError("Insert gagal!!")
                it.printStackTrace()
            })

        }
    }

    override fun getAll() {
        var realm = mPresenter?.mView?.getRealm()
        var query = realm?.where(RealmMdl::class.java)
        var results = query?.findAll()
        Log.e("TAG", "size : ${results!!.size}")
        mPresenter?.getAllSuccess(results)

    }

    override fun delete(data: RealmMdl) {
    }

}