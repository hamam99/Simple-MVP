package com.code_breaker.mvp.db_room

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.code_breaker.mvp.R
import kotlinx.android.synthetic.main.fragment_room_main.*

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class RoomFragment : Fragment() {

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
