package com.mediatechindo.kakilima.merchant.helper

import com.code_breaker.loginmvp.google_book.BookMdl
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    //    LOGIN
    @GET("volumes")
    fun searchBookByIsdb(@Query("q") isbn: String): Observable<Response<BookMdl>>

}
