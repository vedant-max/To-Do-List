package com.example.to_dolist.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  upsert(item: ListItem)

    @Delete
    suspend fun delete(item:ListItem)

    @Query("SELECT * FROM list_item")
    fun getAllitems() : LiveData<List<ListItem>>
}