package com.code_breaker.mvp.realm

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.code_breaker.mvp.R
import com.code_breaker.mvp.db_room.db.RoomMdl

class RealmRvAdapter(val mValues: List<RealmMdl>, var mListener: RVListener) : RecyclerView.Adapter<RealmRvAdapter.ViewHolder>() {

    public override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_room_item, parent, false)
        return ViewHolder(view)
    }

//    var mListener: RVListener?=null

    public override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues.get(position)

        holder.mId.text = item.id.toString()
        holder.mTitle.text = item.title.toString()
        holder.mAuthor.text = item.author.toString()
        holder.mPublisher.text = item.publisher.toString()

        holder.mView.setOnClickListener(object : View.OnClickListener {
            public override fun onClick(v: View) {
                mListener?.onUpdate(item, position)
            }
        })

        holder.mView.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                mListener?.onDelete(item, position)
                return true
            }
        })

    }

    public override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mId: TextView
        val mTitle: TextView
        val mAuthor: TextView
        val mPublisher: TextView


        init {
            mId = mView.findViewById(R.id.id) as TextView
            mTitle = mView.findViewById(R.id.title) as TextView
            mAuthor = mView.findViewById(R.id.author) as TextView
            mPublisher = mView.findViewById(R.id.publisher) as TextView
        }

    }

    interface RVListener {
        fun onDelete(item: RealmMdl, position: Int)
        fun onUpdate(item: RealmMdl, position: Int)
    }
}
