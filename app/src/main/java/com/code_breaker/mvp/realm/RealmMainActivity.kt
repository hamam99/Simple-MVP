package com.code_breaker.mvp.realm

import android.os.Bundle
import android.view.View
import com.code_breaker.mvp.R
import com.code_breaker.mvp.base.BaseMVPActivity
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_realm_main.*
import org.jetbrains.anko.toast
import java.util.*

class RealmMainActivity : BaseMVPActivity<RealmContract.View, RealmPresenter>(), RealmContract.View, RealmRvAdapter.RVListener {
    override fun cleanScreen() {
        realmTitle?.setText(null)
        realmAuthor?.setText(null)
        realmPublisher?.setText(null)
    }

    override fun hideKeyboards(view: View?) {
        super.hideKeyboard(view)
    }

    override fun onError(message: String) {
        toast(message)
    }

    override fun onSuccess(message: String) {
        toast(message)
    }

    override fun onDelete(item: RealmMdl, position: Int) {

    }

    override fun onUpdate(item: RealmMdl, position: Int) {
    }

    override fun getRealm(): Realm {
        return Realm.getDefaultInstance()
    }

    override var mPresenter: RealmPresenter = RealmPresenter()

    override fun insertRes() {
        toast("insert berhasil!")
        mPresenter?.getAll()
        mPresenter?.cleanScreen()
    }

    override fun getAll(result: RealmResults<RealmMdl>?) {

        list.clear()
        list.addAll(result!!)

        adapter?.notifyDataSetChanged()
    }

    override fun delete() {
    }

    var list: ArrayList<RealmMdl> = ArrayList()
    var adapter = RealmRvAdapter(list, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm_main)

        Realm.init(this)

        realmRv?.adapter = adapter
        adapter?.mListener = this

        mPresenter?.getAll()


        realmAdd?.setOnClickListener {
            var data = RealmMdl()
//            data?.id = UUID.randomUUID().toString();
            data?.author = realmTitle?.text.toString().trim()
            data?.publisher = realmPublisher?.text.toString().trim()
            data?.title = realmTitle?.text.toString().trim()
            mPresenter?.insert(data)

            mPresenter?.hideKeyboard(realmTitle)
        }
    }
}
