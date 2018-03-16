package com.code_breaker.loginmvp.google_book

import android.widget.EditText

/**
 * Created by akira on 16/03/18.
 */
interface BookContract {
    interface View {
        fun search(isbn: String)
        fun showLoading(show: Boolean)
        fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean)
        fun onError()
        fun clearScreen()
        fun setErrorEditText(message:String)
    }

    interface Presenter {
        fun onSearch(isbn: String)
        fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean)
        fun onError()
        fun setErrorEditText(message:String)
    }

    interface Interactor {
        fun doSearch(isbn: String, presenter: Presenter)
    }

}