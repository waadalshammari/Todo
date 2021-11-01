package com.example.todolistapp.model

import android.widget.ImageView
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ToDoListModel(
 val title : String,
 val description : String,
 val date : String,
 val check : Boolean = false,
 //val editbutton : ImageView,
 //val deletebutton : ImageView,


 @PrimaryKey(autoGenerate = true)
 val id: Int = 0
)
