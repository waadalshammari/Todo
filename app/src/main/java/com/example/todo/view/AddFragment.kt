package com.example.todolistapp.view
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import java.text.SimpleDateFormat
import java.util.*


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

         // the add fragment

        val titleEditText: EditText = view.findViewById(R.id.title_add)
        val desEditText: EditText = view.findViewById(R.id.des_add)
        val addButton: Button = view.findViewById(R.id.add_button)
        val dateAdd: TextView = view.findViewById(R.id.date_add)


        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val des = desEditText.text.toString()
            val date = dateAdd.text.toString()

             // to make sure if empty will not crash
            if (des.isNotEmpty() && date.isNotEmpty()) {

            }
            todolistViewModel.addItem(title, des, date)
            findNavController().popBackStack()
            // ^^ close screen
        }
        // for date Picker to show by click on the date text.
        dateAdd.setOnClickListener {

            //getting current day,month and year.

            val calendar: Calendar = Calendar.getInstance()
            val year: Int = calendar.get(Calendar.YEAR)
            var month: Int = calendar.get(Calendar.MONTH)
            val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

            // date >>>> how to show on the date text after choose date
            val date = DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener { view, year, month, day ->

                dateAdd.text = ("" + day + "/" + (month.toInt() + 1 ).toString() + "/" + year)
            }, year, month, day)
            date.show()
        }

}}


