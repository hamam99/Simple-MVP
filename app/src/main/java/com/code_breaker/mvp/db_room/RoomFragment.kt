package com.code_breaker.mvp.db_room

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.code_breaker.mvp.R
import com.code_breaker.mvp.db_room.db.RoomContract
import com.code_breaker.mvp.db_room.db.RoomDb
import kotlinx.android.synthetic.main.fragment_room_main.*


class RoomFragment : Fragment(), RoomContract.View {

    lateinit var presenter: RoomPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_room_main, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val db = RoomDb.getAppDatabase(activity)
        presenter = RoomPresenter(db)
//        presenter?.setDb(db)

        roomAdd?.setOnClickListener {
            val title = roomTitle?.text.toString().trim()
            val author = roomAuthor?.text.toString().trim()
            val publisher = roomPublisher?.text.toString().trim()

            var roomMdl = RoomMdl()
            roomMdl.title = title
            roomMdl.author = author
            roomMdl.publisher = publisher
            presenter?.insert(roomMdl)


            Toast.makeText(activity,"add",Toast.LENGTH_SHORT).show()
        }


    }

    override fun insertSuccess(message: String) {
//        Snackbar.make(main_layout, message, Snackbar.LENGTH_SHORT).show()
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
        roomTitle?.setText(null)
        roomAuthor?.setText(null)
        roomPublisher?.setText(null)
    }

    override fun loadAll(rooms: List<RoomMdl>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
//        Snackbar.make(main_layout, message, Snackbar.LENGTH_SHORT).show()
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
        Log.e("TAG"," I am on Error! 1_1")
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

