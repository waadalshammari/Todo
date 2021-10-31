package com.example.todolistapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
@Database (entities = [ToDoListModel::class] , version = 1)
abstract class ToDoListDatabase  : RoomDatabase (){

    abstract fun todolistDao(): ToDoListDao

}