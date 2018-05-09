package com.code_breaker.mvp.realm

import android.util.Log
import io.realm.Realm
import io.realm.Realm.Transaction.OnError
import io.realm.Realm.Transaction.OnSuccess
import io.realm.RealmResults


class RealmInteractor(var mPresenter: RealmContract.Presenter) : RealmContract.Interactor {
    override fun insert(data: RealmMdl) {
        var realm = mPresenter?.mView?.getRealm()
//        var realm = Realm.getDefaultInstance()

/*
        realm?.beginTransaction()
//        realm?.copyFromRealm(data)
        realm?.insert(data)
        realm?.commitTransaction()
*/

        realm?.executeTransactionAsync(object : Realm.Transaction {
            override fun execute(bgRealm: Realm) {
//                var dt= bgRealm.createObject(RealmMdl::class.java)
//                bgRealm.copyFromRealm(data)   //berat klo pake primary key
                bgRealm.insert(data)
                Log.e("TAG","author : ${data.id}")
            }
        }, OnSuccess {
            // Transaction was a success.
            mPresenter?.insertRes()
        }, OnError {
            mPresenter?.onError("Insert gagal!!")
            it.printStackTrace()
        })
    }

    override fun getAll(): RealmResults<RealmMdl> {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(data: RealmMdl) {
    }

}