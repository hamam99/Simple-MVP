package com.code_breaker.mvp.db_room

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.code_breaker.mvp.R
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.fragment_room_main.*


class RoomFragment : Fragment(), RoomContract.View {
    override fun loadAll(): Flowable<List<RoomMdl>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun search(title: String): Flowable<List<RoomMdl>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(roomMdl: RoomMdl) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(roomMdl: RoomMdl) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAttachView() {
        presenter?.onAttach(this)
    }

    override fun onDetachView() {
        presenter?.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onDetachView()
    }

    lateinit var presenter: RoomPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_room_main, container, false)

        // Set the adapter
        roomRv.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = RoomPresenter()

        roomAdd?.setOnClickListener {

        }

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

