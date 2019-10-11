package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.models.User
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        val user1 = User("User1", "pass")
        val user2 = User("User2", "pass")
        val user3 = User("User3", "pass")

        val users = mutableListOf<User>()
        users.add(user1)
        users.add(user2)
        users.add(user3)

        val linearLayoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(users)

        user_list.layoutManager = linearLayoutManager
        user_list.adapter = userAdapter


    }
}
