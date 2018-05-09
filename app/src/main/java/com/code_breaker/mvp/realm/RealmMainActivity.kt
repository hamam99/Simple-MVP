package com.code_breaker.mvp.realm

import android.os.Bundle
import com.code_breaker.mvp.R
import com.code_breaker.mvp.base.BaseMVPActivity
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.fragment_room_main.*
import org.jetbrains.anko.toast
import java.util.*

class RealmMainActivity : BaseMVPActivity<RealmContract.View, RealmPresenter>(), RealmContract.View, RealmRvAdapter.RVListener {
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
    }

    override fun getAll(result: RealmResults<RealmMdl>?) {
    }

    override fun delete() {
    }

    var list: ArrayList<RealmMdl> = ArrayList()
    var adapter = RealmRvAdapter(list, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm_main)

        Realm.init(this)

        roomRv?.adapter = adapter
        adapter?.mListener = this


        realmAdd?.setOnClickListener {
            var data = RealmMdl()
//            data?.id = UUID.randomUUID().toString();
            data?.author = "author"
            data?.publisher = "Publisher"
            data?.title = "title"
            mPresenter?.insert(data)
        }
    }
}
