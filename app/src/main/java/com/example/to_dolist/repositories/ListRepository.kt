package com.example.to_dolist.repositories

import com.example.to_dolist.data.ListDatabase
import com.example.to_dolist.data.Entities.ListItem

class ListRepository(private var db : ListDatabase) {

    suspend fun upsert(item: ListItem) = db.getListDao().upsert(item)

    suspend fun delete(item: ListItem) = db.getListDao().delete(item)

    fun getAllItems() = db.getListDao().getAllitems()
}