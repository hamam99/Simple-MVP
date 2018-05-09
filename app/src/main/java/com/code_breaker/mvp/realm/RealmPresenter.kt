package com.code_breaker.mvp.realm

class RealmPresenter() : RealmContract.Presenter {
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
        mView?.getAll(mInteractor?.getAll())
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