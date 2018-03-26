package com.code_breaker.mvp.google_book

/**
 * Created by akira on 16/03/18.
 */
public class BookPresenter() : BookContract.Presenter {

    var view: BookContract.View? = null

    override fun onAttach(view: BookContract.View) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }


    override fun onSearch(isbn: String) {
        view?.showLoading(true)
        view?.setErrorEditText(null)

        val bookInteractor: BookInteractor = BookInteractor(this)
        bookInteractor.doSearch(isbn)
    }

    override fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean) {
        view?.showLoading(false)
        view?.onSuccess(book)
    }

    override fun onError(message: String?) {
        view?.showLoading(false)
        view?.onError(message)
    }

    override fun setErrorEditText(message: String) {
        view?.showLoading(false)
        view?.setErrorEditText(message)
    }


}