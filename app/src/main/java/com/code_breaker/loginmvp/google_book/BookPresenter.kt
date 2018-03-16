package com.code_breaker.loginmvp.google_book

/**
 * Created by akira on 16/03/18.
 */
public class BookPresenter(var view: BookContract.View) : BookContract.Presenter {

    override fun onSearch(isbn: String) {
        view.showLoading(true)
        val bookInteractor = BookInteractor()
        bookInteractor.doSearch(isbn,this)
    }

    override fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean) {
        view.showLoading(false)
        view.onSuccess(book)
    }

    override fun onError(message: String?) {
        view.showLoading(false)
        view.onError(message)
    }

    override fun setErrorEditText(message: String) {
        view.showLoading(false)
        view.setErrorEditText(message)
    }

}