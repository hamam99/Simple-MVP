package com.code_breaker.mvp.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseMVPFragment<in V : BaseView, T : BasePresenter<V>> : Fragment(), BaseView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as AppCompatActivity
        mPresenter.onAttach(this as V)
//        setHasOptionsMenu(true)
    }

    override fun getContext(): Context = activity as Context

    protected abstract var mPresenter: T
    protected lateinit var mActivity: AppCompatActivity

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDetach()
    }

}