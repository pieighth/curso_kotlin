package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.TodoListAdapter
import com.example.todolist.models.TodoList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val ID_REQUEST = 666

    val todoListAdapter = TodoListAdapter(mutableListOf<TodoList>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList1 = TodoList(1, "Descricao 1", false)
        val todoList2 = TodoList(2, "Descricao 2", false)
        val todoList3 = TodoList(3, "Descricao 3", true)

        val todoLists = mutableListOf<TodoList>(todoList1)
        todoLists.add(todoList2)
        todoLists.add(todoList3)

        val linearLayoutManager = LinearLayoutManager(this)

        todo_list.layoutManager = linearLayoutManager
        todo_list.adapter = todoListAdapter


        todoListAdapter.addAll(todoLists)

        id_task.setOnClickListener{
            val intent = Intent(applicationContext, FormActivity::class.java)
            startActivityForResult(intent, ID_REQUEST)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ID_REQUEST){
            if(resultCode == RESULT_OK){
                data?.let {
                    val description = it.getStringExtra("todo")
                    val status = it.getBooleanExtra("status", false)
                    todoListAdapter.add(TodoList(4, description, status))
                }
            }
        }
    }
}
