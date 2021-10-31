package com.example.todolistapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ToDoListModel(
 val title : String,
 val description : String,
 val check : Boolean,
 val date : String,

 @PrimaryKey(autoGenerate = true)
 val id: Int = 0
)
