package com.code_breaker.loginmvp.base

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
interface BasePresenter<T : BaseView> {
    fun onAttach(view: T)

    fun onDetach()
}