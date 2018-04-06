package com.code_breaker.mvp.google_book

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.code_breaker.mvp.R
import com.code_breaker.mvp.base.BaseMVPActivity
import kotlinx.android.synthetic.main.activity_book.*

class BookActivity : BaseMVPActivity<BookContract.View, BookPresenter>(), BookContract.View {

    override fun getContext(): Context = this
    override var mPresenter = BookPresenter()


/*
    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }
*/

/*
    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }
*/


//    var presenter: BookPresenter = BookPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_book)

        bookEtSearch.setText("9780345472328")
//        presenter = BookPresenter()


        bookBtnSearch.setOnClickListener {
            val isbn = bookEtSearch.text.toString().trim()
            mPresenter.onSearch(isbn)

        }

    }

    override fun showLoading(show: Boolean) {
        if (show) bookProgressBar.visibility = View.VISIBLE
        else bookProgressBar.visibility = View.GONE
    }

    override fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean) {
        bookTvTitle.text = " : " + book.title
        bookAuthor.text = " : " + book.authors.toString()
        bookTvPublisher.text = " : " + book.publisher
        bookTvDesk.text = book.description

    }

    override fun onError(message: String?) {
        Snackbar.make(main_layout, message!!, Snackbar.LENGTH_SHORT).show()
    }

    override fun clearScreen() {
        bookEtSearch.setText(null)
        bookTvTitle.text = null
        bookAuthor.text = null
        bookTvPublisher.text = null
        bookTvDesk.text = null
    }

    override fun setErrorEditText(message: String?) {
        if (message != null) {
            bookEtSearch.setError(message)
            bookEtSearch.requestFocus()
        } else bookEtSearch.setError(null)


    }

}
