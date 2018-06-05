package com.code_breaker.mvp.realm

import android.view.View
import io.realm.RealmResults

class RealmPresenter() : RealmContract.Presenter {
    override fun cleanScreen() {
        mView?.cleanScreen()
    }

    override fun hideKeyboard(view: View?) {
        mView?.hideKeyboards(view)
    }

    override fun getAllSuccess(realms: RealmResults<RealmMdl>) {
        mView?.getAll(realms)
    }

    override fun onError(message: String) {
        mView?.onError(message)
    }

    override fun onSuccess(message: String) {
        mView?.onSuccess(message)
    }

    override var mView: RealmContract.View? = null
    override var mInteractor: RealmContract.Interactor? = RealmInteractor(this)

    override fun insert(data: RealmMdl) {
        mInteractor?.insert(data)
    }

    override fun insertRes() {
        mView?.insertRes()
    }

    override fun getAll() {
        mInteractor?.getAll()
    }

    override fun delete(data: RealmMdl) {
        mInteractor?.delete(data)
    }

    override fun deleteRes() {
        mView?.delete()
    }

    override fun onAttach(view: RealmContract.View) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

}