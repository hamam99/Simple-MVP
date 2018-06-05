package com.code_breaker.mvp.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

abstract class BaseMVPActivity<in V : BaseView, T : BasePresenter<V>> : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.onAttach(this as V)
    }

//    override fun attachBaseContext(newBase: Context) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
//    }

    override fun getContext(): Context = this

    protected abstract var mPresenter: T

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDetach()
    }

    protected fun setupToolbar(toolbar: Toolbar, tvTitle: TextView, title: String, enableHomeBack: Boolean) {
        tvTitle.text = title
        toolbar.title = ""
        setSupportActionBar(toolbar)
        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(enableHomeBack)
        }

        toolbar.setNavigationOnClickListener {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack()
            } else {
                finish()
            }
        }
    }

    fun hideKeyboard(view: View?) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}

