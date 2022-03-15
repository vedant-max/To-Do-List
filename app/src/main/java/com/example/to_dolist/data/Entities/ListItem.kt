package com.example.to_dolist.data.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_item")
data class ListItem(
    @ColumnInfo(name = "item_brief")
    var brief: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
