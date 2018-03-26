package com.code_breaker.mvp.Login

/**
 * Created by akira on 16/03/18.
 */
public class LoginPresenter(var views: LoginContract.View) : LoginContract.Presenter {

    override fun onSuccess() {
        views.showProgress(false)
        views.onSuccess("Login Success!")
    }

    override fun onError() {
        views.showProgress(false)
        views.onError("Login error!")
    }

    override fun onLogin(loginMdl: LoginMdl) {
        var interactor = LoginInteractor()
        interactor.attempLogin(loginMdl, this)
        views.showProgress(true)
    }
}