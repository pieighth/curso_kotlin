package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
        login.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, user_name.text.toString())
            Log.d(MainActivity::class.java.simpleName, user_pass.text.toString())

        }
    }
}
