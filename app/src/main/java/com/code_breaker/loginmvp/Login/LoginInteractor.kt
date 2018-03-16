package com.code_breaker.loginmvp.Login

import android.os.Handler

/**
 * Created by akira on 16/03/18.
 */

public class LoginInteractor() : LoginContract.Interactor {
    override fun attempLogin(loginMdl: LoginMdl, login: LoginContract.Presenter) {
        Handler().postDelayed({
            if (loginMdl.email.length > 3 && loginMdl.pass.length > 3) {
                login.onSuccess()
            } else {
                login.onError()
            }
        }, 1000)
    }

}