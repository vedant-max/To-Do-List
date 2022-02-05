package com.example.to_dolist.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.to_dolist.R
import com.example.to_dolist.data.ListItem
import com.example.to_dolist.ui.ListViewModel
import kotlinx.android.synthetic.main.list_item.view.*

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