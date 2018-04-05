package com.code_breaker.mvp.google_book

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.code_breaker.mvp.R
import kotlinx.android.synthetic.main.activity_book.*

class BookActivity : AppCompatActivity(), BookContract.View {
    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }


    lateinit var presenter: BookPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        bookEtSearch.setText("9780345472328")
        presenter = BookPresenter()
        onAttachView()


        bookBtnSearch.setOnClickListener {
            val isbn = bookEtSearch.text.toString().trim()
            presenter.onSearch(isbn)

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
