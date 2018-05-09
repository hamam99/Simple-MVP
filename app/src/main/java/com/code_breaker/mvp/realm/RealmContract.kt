package com.code_breaker.mvp.realm

import com.code_breaker.mvp.base.BasePresenter
import com.code_breaker.mvp.base.BaseView
import io.realm.Realm
import io.realm.RealmResults

interface RealmContract {
    interface View : BaseView {
        fun insertRes()
        fun getAll(result: RealmResults<RealmMdl>?)

        fun delete()

        fun getRealm():Realm

        fun onError(message:String)
        fun onSuccess(message:String)
    }

    interface Presenter : BasePresenter<View> {
        var mView: View?
        var mInteractor: Interactor?

        fun insert(data: RealmMdl)
        fun insertRes()

        fun getAll()

        fun delete(data:RealmMdl)
        fun deleteRes()

        fun onError(message:String)
        fun onSuccess(message:String)
    }

    interface Interactor {
        fun insert(data: RealmMdl)
        fun getAll(): RealmResults<RealmMdl>
        fun delete(data:RealmMdl)

    }
}