package com.example.todolistapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.todo.R


class AddFragment : Fragment() {

    private val todolistViewModel: ToDoListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleEditText: EditText = view.findViewById(R.id.title_add)
        val desEditText: EditText = view.findViewById(R.id.des_add)
        val dateEditText: EditText = view.findViewById(R.id.date_add)
//        val dateButton: Button = view.findViewById(R.id.date_button_add)
        val addButton: Button = view.findViewById(R.id.add_button)

        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val des = desEditText.text.toString()
            val date = dateEditText.text.toString().toInt()
           // val dateButton = dateButton

            // how i put the date button ?? or i dont need it

               todolistViewModel.addItem(title,des, false ,date)

            }



        }

    }
