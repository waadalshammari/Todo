package com.example.todolistapp.model

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ToDoListDao {

    @Insert
    suspend fun addItem (toDoListModel: ToDoListModel)

    @Query ("SELECT * FROM todolistmodel")
    fun getItem () : LiveData<List<ToDoListModel>>

    @Update
    suspend fun updateItem (toDoListModel: ToDoListModel)

    @Delete
    suspend fun deleteItem(toDoListModel: ToDoListModel)
}