package com.code_breaker.loginmvp.google_book

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.code_breaker.loginmvp.R
import kotlinx.android.synthetic.main.activity_book.*

class BookActivity : AppCompatActivity(), BookContract.View {

    lateinit var presenter: BookPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)


        presenter = BookPresenter(this)

    }

    override fun search(isbn: String) {
        presenter.onSearch("isbn:$isbn")
    }

    override fun showLoading(show: Boolean) {
        if (show) bookProgressBar.visibility = View.VISIBLE
        else bookProgressBar.visibility = View.GONE
    }

    override fun onSuccess(book: BookMdl.ItemsBean.VolumeInfoBean) {
        bookTvTitle.text = book.title
        bookAuthor.text = book.authors.toString()
        bookTvPublisher.text = book.publisher
        bookTvDesk.text = book.description

    }

    override fun onError() {
        Snackbar.make(main_layout, "TErjadi kesalahan!", Snackbar.LENGTH_SHORT).show()
    }

    override fun clearScreen() {
        bookEtSearch.setText(null)
        bookTvTitle.text = null
        bookAuthor.text = null
        bookTvPublisher.text = null
        bookTvDesk.text = null
    }

    override fun setErrorEditText(message: String) {
        bookEtSearch.setText(message)
        bookEtSearch.requestFocus()

    }

}
