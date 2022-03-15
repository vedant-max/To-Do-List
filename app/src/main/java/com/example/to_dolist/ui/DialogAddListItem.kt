package com.example.to_dolist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.to_dolist.R
import com.example.to_dolist.data.Entities.ListItem
import kotlinx.android.synthetic.main.dialog_add_listitem.*
import kotlinx.android.synthetic.main.list_item.*

class DialogAddListItem(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_add_listitem)
        tvAdd.setOnClickListener {
            val task = tvListItem.text.toString()
            if(task.isEmpty()){
                Toast.makeText(context,"Input task or press cancel",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ListItem(task)
            addDialogListener.onAddDialogListener(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}