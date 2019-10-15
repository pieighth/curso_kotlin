package com.example.todolist.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.DetalheActivity
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

        holder.bindData(todo, position)
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

        @SuppressLint("ResourceAsColor")
        fun bindData(todoList: TodoList, position: Int){

            view.description_item.text = todoList.description.toString()
            view.check_status_item.isChecked = todoList.status
/*          TODO: Tentar fazer funcionar a questao das cores das celulas
            val resto = position % 2
            if (resto == 0 ) {
                view.setBackgroundColor(android.R.color.holo_green_dark)

            }else{
                view.setBackgroundColor(android.R.color.holo_blue_dark)
            }
    */
            view.check_status_item.setOnClickListener {
                todoList.status = !it.check_status_item.isChecked
            }

            view.setOnClickListener {
                Toast.makeText(view.context, view.description_item.text, Toast.LENGTH_LONG).show()

                val intent = Intent(view.context, DetalheActivity::class.java)

                intent.putExtra(DetalheActivity.TODO_TAG, todoList)

                view.context.startActivity(intent)



            }

        }

    }
}


