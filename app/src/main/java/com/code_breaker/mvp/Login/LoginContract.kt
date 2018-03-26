package com.code_breaker.mvp.Login

/**
 * Created by akira on 16/03/18.
 */

interface  LoginContract{
    interface View{
        fun onError(pesan:String)
        fun onSuccess(pesan:String)
        fun showProgress(isShown:Boolean)
    }
    interface Presenter{
        fun onLogin(loginMdl: LoginMdl)
        fun onSuccess()
        fun onError()
    }
    interface  Interactor{
        fun attempLogin(loginMdl: LoginMdl, login: Presenter)
    }

}