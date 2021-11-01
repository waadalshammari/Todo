package com.example.todolistapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo.R


class EditFragment : Fragment() {
    private val todolistViewModel: ToDoListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleEditText: EditText = view.findViewById(R.id.title_edit)
        val desEditText: EditText = view.findViewById(R.id.des_edit)
        val dateEditText: EditText = view.findViewById(R.id.date_edit)
       // val dateButton: Button = view.findViewById(R.id.date_button_edit)
        val editButton: Button = view.findViewById(R.id.edite_button)

    editButton.setOnClickListener {
        val title = titleEditText.text.toString()
        val des = desEditText.text.toString()
        val date = dateEditText.text.toString()

        todolistViewModel.addItem(title,des, false ,date)

    }
} }