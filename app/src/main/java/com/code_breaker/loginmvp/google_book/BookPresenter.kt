package com.code_breaker.loginmvp.google_book

/**
 * Created by akira on 16/03/18.
 */
public class BookPresenter(var view: BookContract.View) : BookContract.Presenter {

    override fun onSearch(isbn: String) {
        view.showLoading(true)


    }

    override fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean) {
    }

    override fun onError() {
    }

    override fun setErrorEditText(message: String) {
    }

}