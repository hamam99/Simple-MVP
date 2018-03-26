package com.code_breaker.mvp.db_room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.code_breaker.mvp.R
import com.code_breaker.mvp.R.id.room_container

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(room_container, RoomFragment.newInstance())
        fragmentTransaction.commit()
    }
}
