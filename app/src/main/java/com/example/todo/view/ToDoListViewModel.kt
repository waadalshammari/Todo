package com.example.todolistapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.model.ToDoListModel
import com.example.todolistapp.repositrey.ToDoListRepositry
import kotlinx.coroutines.launch

class ToDoListViewModel : ViewModel() {

    private val todolistRepositry = ToDoListRepositry.get()

    var todolisttask = todolistRepositry.getItems()


    var task: ToDoListModel? = null
    var selectedItemMutableLiveDate = MutableLiveData<ToDoListModel>()

    fun addItem(title: String, description: String, check: Boolean, date: Int) {
        viewModelScope.launch {
            todolistRepositry.addItem(ToDoListModel(title, description, check , date))
        }
    }

    fun updateItem(toDoListModel: ToDoListModel) {
        viewModelScope.launch {
            todolistRepositry.updateItem(toDoListModel)
        }
    }

    fun deleteItem(toDoListModel: ToDoListModel) {
        viewModelScope.launch {
            todolistRepositry.deleteItem(toDoListModel)
        }
    }
}
