package com.example.todolistapp.repositrey

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.todolistapp.model.ToDoListDao
import com.example.todolistapp.model.ToDoListDatabase
import com.example.todolistapp.model.ToDoListModel
import java.lang.Exception


private const val DATABASE_NAME = "todolist-database"
class ToDoListRepositry (context: Context) {

    private val database: ToDoListDatabase =
        Room.databaseBuilder(
            context,
            ToDoListDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    private val ToDoListDao = database.todolistDao()

    fun getItems() = ToDoListDao.getItem()

    suspend fun addItem(todoListModel: ToDoListModel) = ToDoListDao.addItem(todoListModel)
    suspend fun updateItem(todoListModel: ToDoListModel) = ToDoListDao.updateItem(todoListModel)
    suspend fun deleteItem(todoListModel: ToDoListModel) = ToDoListDao.deleteItem(todoListModel)

    companion object {
        private var instance: ToDoListRepositry? = null

        fun init(context: Context) {
            if (instance == null)
                instance = ToDoListRepositry(context)
        }

        fun get(): ToDoListRepositry {
            return instance ?: throw Exception("To Do List Repository must be initialized")
        }
    }
}