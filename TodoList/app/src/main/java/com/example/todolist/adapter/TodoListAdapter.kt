package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.models.TodoList
import kotlinx.android.synthetic.main.todolist_list_item.view.*


class TodoListAdapter(private val todoLists: MutableList<TodoList>): RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>() {

    fun addAll(todo: MutableList<TodoList>){

        this.todoLists.addAll(todo)
        notifyDataSetChanged()
    }
    fun add(todo: TodoList){

        this.todoLists.add(todo)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        val todo =todoLists[position]

        holder.bindData(todo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.todolist_list_item, parent, false)
        val viewHolder = TodoListViewHolder(view)
        return viewHolder

    }

    override fun getItemCount(): Int {
        return todoLists.size
    }



    class TodoListViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bindData(todoList: TodoList){
            view.id_item.text = todoList.id.toString()
            view.description_item.text = todoList.description.toString()
            view.status_item.text = todoList.status.toString()

        }

    }
}


