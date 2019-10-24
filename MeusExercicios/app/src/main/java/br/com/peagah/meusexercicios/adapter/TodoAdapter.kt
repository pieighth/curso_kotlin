package br.com.peagah.meusexercicios.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.peagah.meusexercicios.R
import br.com.peagah.meusexercicios.models.Todo
import kotlinx.android.synthetic.main.todo_list_item.view.*

class TodoAdapter(private val todos: MutableList<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflate = inflater.inflate(R.layout.todo_list_item, parent, false)
        val viewHolder = TodoViewHolder(inflate)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.bindData(todo,position)
    }

    fun add(todo: Todo) {
        this.todos.add(todo)

    }


    class TodoViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindData(todo: Todo, position: Int){

            
        }
    }
}