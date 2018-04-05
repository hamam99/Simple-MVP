package com.code_breaker.mvp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.code_breaker.mvp.Login.MainActivity
import com.code_breaker.mvp.db_room.RoomActivity
import com.code_breaker.mvp.google_book.BookActivity
import kotlinx.android.synthetic.main.activity_main_home.*

class MainHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        homeLogin?.setOnClickListener { onClick(1)}
        homeGoogleBook?.setOnClickListener { onClick(2) }
        homeRoom?.setOnClickListener { onClick(3) }
    }

     fun onClick(id:Int) {

        var intent: Intent? = null
        when (id) {
            1 -> intent = Intent(this, MainActivity::class.java)
            2 -> intent = Intent(this, BookActivity::class.java)
            3 -> intent = Intent(this, RoomActivity::class.java)
        }
        if (intent != null) startActivity(intent)
    }


}
