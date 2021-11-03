package com.example.todolistapp.view

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.example.todolistapp.model.ToDoListModel
import java.text.SimpleDateFormat
import java.util.*


class EditFragment : Fragment() {
    private val todolistViewModel: ToDoListViewModel by activityViewModels()

    // عشان لما يدخل على صفحه التعديل تطلع له الصفحه القديمه مو جديده
    // for edit fragment saved data 1
    private lateinit var selectedTask: ToDoListModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // the edit fragment

        val titleEditText: EditText = view.findViewById(R.id.title_edit)
        val desEditText: EditText = view.findViewById(R.id.des_edit)
        val dateedit: TextView = view.findViewById(R.id.date_edit)
        val editButton: Button = view.findViewById(R.id.edite_button)

        // عشان لما يدخل على صفحه التعديل تطلع له الصفحه القديمه مو جديده
        // edit fragment saved data 2
        // live data>>> any changes save it
        todolistViewModel.selectedItemMutableLiveDate.observe(viewLifecycleOwner, {
            it?.let { task ->

                titleEditText.setText(task.title)
                desEditText.setText(task.description)
                dateedit.setText(task.date)

             selectedTask = task
            }
        })

    editButton.setOnClickListener {
        val title = titleEditText.text.toString()
        val des = desEditText.text.toString()
        val date = dateedit.text.toString()

        if (title.isNotEmpty() && date.isNotEmpty()){

        }
        // عشان لما يدخل على صفحه التعديل تطلع له الصفحه القديمه مو جديده
        // to open edit fragment with saved data  3
        selectedTask.title = title
        selectedTask.description = des
        selectedTask.date= date
        todolistViewModel.updateItem(selectedTask)

        findNavController().popBackStack()

    }

        dateedit.setOnClickListener {

            //getting current day,month and year.

            val calendar: Calendar = Calendar.getInstance()
            val year: Int = calendar.get(Calendar.YEAR)
            val month: Int = calendar.get(Calendar.MONTH)
            val day: Int = calendar.get(Calendar.DAY_OF_MONTH)


            val Date = DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener
            { view, year, month, day ->

                dateedit.text = ("" + day + "/" + (month.toInt() + 1 ).toString() + "/" + year)            }, year, month, day)
            Date.show()
        }
        }
        }