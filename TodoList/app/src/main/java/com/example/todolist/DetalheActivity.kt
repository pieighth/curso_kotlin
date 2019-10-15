package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.R
import com.example.todolist.models.TodoList
import kotlinx.android.synthetic.main.activity_detalhe.*

class DetalheActivity : AppCompatActivity() {

    companion object{
        val TODO_TAG = "TODO"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        intent.extras?.let {
            val todoList = intent.getParcelableExtra<TodoList>(TODO_TAG)
            detail_description.text = todoList.description
            detail_checked.text =todoList.status.toString()


        }
    }


}
