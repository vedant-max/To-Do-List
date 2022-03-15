package com.example.to_dolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.to_dolist.data.Entities.ListItem
import java.util.concurrent.locks.Lock

@Database(
    entities = [ListItem::class]
    , version = 1
)
abstract class ListDatabase : RoomDatabase() {

    abstract fun getListDao() : ListDao

    companion object{
        @Volatile
        private var instance: ListDatabase ?= null
        private val Lock = Any()
        operator fun invoke(context: Context) = instance
            ?: synchronized(Lock){
                instance?: createDatabase(context).also { instance = it}
            }

        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,ListDatabase::class.java,"ListDB.db").build()
    }
}