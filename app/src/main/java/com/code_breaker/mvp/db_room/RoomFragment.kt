package com.code_breaker.mvp.db_room

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.code_breaker.mvp.R
import com.code_breaker.mvp.base.BaseMVPFragment
import com.code_breaker.mvp.db_room.db.RoomDb
import kotlinx.android.synthetic.main.fragment_room_main.*


public class RoomFragment : BaseMVPFragment<RoomContract.View, RoomPresenter>(), RoomContract.View {

    override var mPresenter: RoomPresenter = RoomPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_room_main, container, false)
        return view
    }

    var adapter: RoomRvAdapter? = null
    var list: ArrayList<RoomMdl> = ArrayList()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        //for testing
        roomTitle.setText("Harry Potter ")
        roomAuthor.setText("JK Rowling")
        roomPublisher.setText("Gak tahu")

        adapter = RoomRvAdapter(list)
        roomRv?.adapter = adapter

        roomAdd?.setOnClickListener {
            val title = roomTitle?.text.toString().trim()
            val author = roomAuthor?.text.toString().trim()
            val publisher = roomPublisher?.text.toString().trim()

            var roomMdl = RoomMdl()
            roomMdl.title = title
            roomMdl.author = author
            roomMdl.publisher = publisher
            mPresenter?.insert(roomMdl)

        }

        val db = RoomDb.getAppDatabase(activity)
        mPresenter?.setDb(db)
        mPresenter.loadAll()

    }

    override fun insertSuccess(message: String) {
//        Snackbar.make(main_layout, message, Snackbar.LENGTH_SHORT).show()
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show()
        roomTitle?.setText(null)
        roomAuthor?.setText(null)
        roomPublisher?.setText(null)
    }

    override fun loadAll(rooms: List<RoomMdl>) {
        if (list.isNotEmpty()) list.clear()
        list.addAll(rooms)
        adapter?.notifyDataSetChanged()
        Log.e("TAG","Fragment : Load All 1")

    }

    override fun search(rooms: List<RoomMdl>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun clearScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
//        Snackbar.make(main_layout, message, Snackbar.LENGTH_SHORT).show()
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        Log.e("TAG", " I am on Error! 1_1")
    }

    override fun loadLatest(rooms: RoomMdl) {
        list.add(rooms)
        adapter?.notifyDataSetChanged()
    }


    companion object {

        // TODO: Customize parameter argument names
        private val ARGS = "arg"

        // TODO: Customize parameter initialization
        fun newInstance(columnCount: String? = null): RoomFragment {
            val fragment = RoomFragment()
            val args = Bundle()
            args.putString(ARGS, columnCount)
            fragment.arguments = args
            return fragment
        }
    }


}

