package com.example.to_dolist.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.to_dolist.data.Entities.ListItem

@Dao
interface ListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun  upsert(item: ListItem)

    @Delete
      fun delete(item: ListItem)

    @Query("SELECT * FROM list_item")
    fun getAllitems() : LiveData<List<ListItem>>
}