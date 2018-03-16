package com.code_breaker.loginmvp.Login

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.code_breaker.loginmvp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginContract.View {

    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginPresenter = LoginPresenter(this)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val pass = etEmail.text.toString().trim()
            loginPresenter.onLogin(LoginMdl(email, pass))
        }
    }

    override fun onError(pesan: String) {
        Snackbar.make(main_layout, pesan, Snackbar.LENGTH_SHORT).show()
    }

    override fun onSuccess(pesan: String) {
        Snackbar.make(main_layout, pesan, Snackbar.LENGTH_SHORT).show()
    }

    override fun showProgress(isShown: Boolean) {
        if (isShown) progressBar.visibility = View.VISIBLE
        else progressBar.visibility = View.GONE
    }
}
