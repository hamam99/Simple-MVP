package com.code_breaker.mvp.realm

import android.view.View
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

        fun hideKeyboards(view:android.view.View?)

        fun cleanScreen()
    }

    interface Presenter : BasePresenter<View> {
        fun hideKeyboard(view:android.view.View?)
        fun cleanScreen()

        var mView: View?
        var mInteractor: Interactor?

        fun insert(data: RealmMdl)
        fun insertRes()


        fun getAll()
        fun getAllSuccess(realms : RealmResults<RealmMdl>)

        fun delete(data:RealmMdl)
        fun deleteRes()

        fun onError(message:String)
        fun onSuccess(message:String)
    }

    interface Interactor {
        fun insert(data: RealmMdl)
        fun getAll()
        fun delete(data:RealmMdl)

    }
}