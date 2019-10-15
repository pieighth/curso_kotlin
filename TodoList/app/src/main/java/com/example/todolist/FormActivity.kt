package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.todolist.models.TodoList
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    val ID_REQUEST = 777
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        save.setOnClickListener {
            val description = task_description.text.toString()
            val status = form_check_status.isChecked()
            val intent = Intent()
            intent.putExtra("todo", description)
            intent.putExtra("status", status)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    
}
