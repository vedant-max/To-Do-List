package com.example.to_dolist.others

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.to_dolist.R
import com.example.to_dolist.data.Entities.ListItem
import com.example.to_dolist.ui.AddDialogListener
import com.example.to_dolist.ui.DialogAddListItem
import com.example.to_dolist.ui.ListViewModel
import com.example.to_dolist.ui.onclickedit
import kotlinx.android.synthetic.main.list_item.view.*
import org.kodein.di.generic.contextFinder
import kotlin.math.abs

class ListItemAdapter(var items: List<ListItem>, private val viewModel: ListViewModel): RecyclerView.Adapter<ListItemAdapter.ListViewHolder>(){

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var currListItem = items[position]
        holder.itemView.tvbrief.text = currListItem.brief
        holder.itemView.delete.setOnClickListener{
            viewModel.delete(currListItem)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}