package br.com.peagah.meusexercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dashboard.*
import br.com.peagah.meusexercicios.adapter.TodoAdapter
import br.com.peagah.meusexercicios.models.Todo

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val linearLayoutManager = LinearLayoutManager(this)
        val todoAdapter = TodoAdapter(mutableListOf<Todo>())

        val todo1 = Todo(1, "primeira tarefa", false)
        todoAdapter.add(todo1)
        dashboard_list_item.layoutManager = linearLayoutManager
        dashboard_list_item.adapter = todoAdapter
    }
}
