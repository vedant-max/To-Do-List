package com.example.to_dolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.to_dolist.R
import com.example.to_dolist.data.ListDatabase
import com.example.to_dolist.repositories.ListRepository

class ToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val database = ListDatabase(this)
        val repository = ListRepository(database)
        val factory = ListViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(ListViewModel::class.java)

    }
}