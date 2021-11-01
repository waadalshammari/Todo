package com.example.todolistapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R

import com.example.todolistapp.model.ToDoListModel

class ToDoListAdapter (val task: List<ToDoListModel>,val viewModel: ToDoListViewModel):
    RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ToDoListAdapter.ToDoListViewHolder {
        return ToDoListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.app_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        val task = task [position]

        holder.titleTextView.text = task.title
        holder.desTextView.text = task.description
        holder.check.text = task.check.toString()


        holder.titleTextView.setOnClickListener {
            viewModel.selectedItemMutableLiveDate.postValue(task)
            it.findNavController().navigate(R.id.action_onboarding_listFragment_to_editFragment)
        }
       holder.deletebutton.setOnClickListener {
         viewModel.deleteItem(task)
       }
       holder.editbutton.setOnClickListener {
           viewModel.selectedItemMutableLiveDate.postValue(task)
           it.findNavController().navigate(R.id.action_onboarding_listFragment_to_editFragment)
       }


    }

    override fun getItemCount(): Int {
        return task.size
    }

    class ToDoListViewHolder (view: View) :RecyclerView.ViewHolder(view){
        val titleTextView : TextView = view.findViewById(R.id.title_textview_applayout)
        val desTextView : TextView = view.findViewById(R.id.des_textview_applayout)
        val check : CheckBox = view.findViewById(R.id.checkBox_app_layout)
        val deletebutton : ImageView = view.findViewById(R.id.delete_button_app_layout)
        val editbutton : ImageView= view.findViewById(R.id.edit_button_app_layout)
        val date : EditText = view.findViewById(R.id.Date)

    }
}