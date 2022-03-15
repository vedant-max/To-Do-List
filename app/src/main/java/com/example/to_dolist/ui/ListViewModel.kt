package com.example.to_dolist.ui

import androidx.lifecycle.ViewModel
import com.example.to_dolist.data.Entities.ListItem
import com.example.to_dolist.repositories.ListRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel(private val repository: ListRepository): ViewModel() {
    fun upsert(item: ListItem) = GlobalScope.launch {
        repository.upsert(item)
    }

    fun delete(item: ListItem) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()
}