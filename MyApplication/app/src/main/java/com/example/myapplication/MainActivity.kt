package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
            Metodo antigo para acessar os componentes da tela

            val - definicao de constante
            var - definicao de variavel

        val userName = findViewById<EditText>(R.id.user_name)
        val userPass = findViewById<EditText>(R.id.user_pass)
        val login = findViewById<Button>(R.id.button)

        login.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, userName.text.toString())
            Log.d(MainActivity::class.java.simpleName, userPass.text.toString())

            print(userName.text.toString())
            print(userPass.text.toString())
        }

        */

        val user1 = User("User1", "pass")
        val user2 = User("User2", "pass")
        val user3 = User("User3", "pass")

        val numbers = mutableListOf(user1, user2)
        numbers.add(0, user3)

        numbers.forEach({
            Log.d("lista", it.userName)
        }
        )

        val intent = Intent(this, SecondActivity::class.java)

        val bundle = Bundle()

        login.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, user_name.text.toString())
            Log.d(MainActivity::class.java.simpleName, user_pass.text.toString())

            /*
            bundle.putString("user_name",user_name.text.toString())
            bundle.putString("user_pass",user_pass.text.toString())
            intent.putExtras(bundle)
            */
            val user = User(user_name.text.toString(), user_pass.text.toString())

            bundle.putParcelable("user", user)
            intent.putExtras(bundle)
            startActivity(intent)

        }
    }
}
