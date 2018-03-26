package com.code_breaker.mvp.google_book

import com.mediatechindo.kakilima.merchant.helper.ApiManager
import retrofit2.Response

/**
 * Created by akira on 16/03/18.
 */
public class BookInteractor(var presenter: BookContract.Presenter) : BookContract.Interactor {
    override fun doSearch(isbn: String) {
        if (isbn.isEmpty()) {
            presenter.setErrorEditText("Please fill the isbn!")
        } else {
            ApiManager.searchByIsdb(isbn)
                    .doOnComplete {

                    }
                    .subscribe(
                            { response: Response<BookMdl> ->

                                if (response.isSuccessful && response.body() != null) {
                                    var body = response.body()!!
                                    if (body.totalItems > 0) {
                                        var volume = body.items!![0].volumeInfo
                                        presenter.onSuccess(volume!!)

                                    } else presenter.onError("Book not found")
                                } else {
                                    presenter.onError("Try again later!")
                                }
                            },
                            { error ->
                                //                            showProgress(progressBar, false)
//                            toast("Terjadi kesalahan. Coba lagi nanti!")
                                presenter.onError("Chek your internet connection!")
                            }
                    )
        }
    }
}