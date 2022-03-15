package com.example.to_dolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_dolist.R
import com.example.to_dolist.data.ListDatabase
import com.example.to_dolist.data.Entities.ListItem
import com.example.to_dolist.others.ListItemAdapter
import com.example.to_dolist.repositories.ListRepository
import kotlinx.android.synthetic.main.activity_todo.*
import kotlinx.android.synthetic.main.dialog_add_listitem.*
import kotlinx.android.synthetic.main.list_item.view.*

class ToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
//        var onclickedit = onclickedit()
        val database = ListDatabase(this)
        val repository = ListRepository(database)
        val context = this
        val factory = ListViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(ListViewModel::class.java)
        val adapter = ListItemAdapter(listOf(),viewModel)

        rvListItem.layoutManager = LinearLayoutManager(this)
        rvListItem.adapter=adapter

        viewModel.getAllItems().observe(this){
            adapter.items=it
            adapter.notifyDataSetChanged()
        }
        fab.setOnClickListener{
            DialogAddListItem(this,object :AddDialogListener{
                override fun onAddDialogListener(item: ListItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }

    }
}