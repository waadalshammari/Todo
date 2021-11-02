package com.example.todolistapp.model

import android.widget.ImageView
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ToDoListModel(
 var title : String,
 var description : String,
 var date : String,
 var check : Boolean = false,
 //val editbutton : ImageView,
 //val deletebutton : ImageView,


 @PrimaryKey(autoGenerate = true)
 val id: Int = 0
)
