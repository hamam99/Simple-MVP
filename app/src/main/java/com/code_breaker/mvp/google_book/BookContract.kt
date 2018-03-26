package com.code_breaker.mvp.google_book

import com.code_breaker.mvp.base.BasePresenter
import com.code_breaker.mvp.base.BaseView

/**
 * Created by akira on 16/03/18.
 */
interface BookContract {
    interface View :BaseView{
        fun showLoading(show: Boolean)
        fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean)
        fun onError(message:String?)
        fun clearScreen()
        fun setErrorEditText(message:String?)
    }

    interface Presenter :BasePresenter<View>{
        fun onSearch(isbn: String)
        fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean)
        fun onError(message:String?)
        fun setErrorEditText(message:String)
    }

    interface Interactor {
        fun doSearch(isbn: String)
    }

}