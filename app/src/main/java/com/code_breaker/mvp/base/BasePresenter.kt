package com.code_breaker.mvp.base

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
interface BasePresenter<in T : BaseView> {
    fun onAttach(view: T)

    fun onDetach()
}