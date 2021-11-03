package com.example.todolistapp.view

import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R

import com.example.todolistapp.model.ToDoListModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        val task = task [position]

        holder.titleTextView.text = task.title
        holder.desTextView.text = task.description
        holder.date.text = task.date



          // due date >>>> pass or not

        val format = SimpleDateFormat("dd/MM/yyyy")
        var currentDate = Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val deadline = format.parse(task.date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

         // if the date pass make the title blue else make it black
        if (deadline.isBefore(currentDate)) {
            holder.titleTextView.setTextColor(Color.RED)
        } else {
            holder.titleTextView.setTextColor(Color.BLACK)
        }

        // check  by the user if task completed or not >> line cross the title

        holder.check.setOnClickListener {
            task.check = holder.check.isChecked
            if (holder.check.isChecked) {
                holder.titleTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
                viewModel.updateItem(task)

            } else {
                holder.titleTextView.setPaintFlags(0)
            }
        }

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
        val date : TextView = view.findViewById(R.id.Date)


    }
}