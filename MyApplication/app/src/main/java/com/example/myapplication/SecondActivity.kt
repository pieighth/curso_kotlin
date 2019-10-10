package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.User

import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        intent.extras.let {

//            val user_name = it?.getString("user_name")
//            val user_pass = it?.getString("user_pass")
//            name.text = user_name
//            pass.text = user_pass

            var user = it?.getParcelable<User>("user")
            name.text = user?.userName
            pass.text = user?.userPass

        }


        fab.setOnClickListener { view ->
            Snackbar.make(view, R.string.mensagem, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
