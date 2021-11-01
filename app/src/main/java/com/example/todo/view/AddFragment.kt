package com.example.todolistapp.view
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
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

        val titleEditText: EditText = view.findViewById(R.id.title_add)
        val desEditText: EditText = view.findViewById(R.id.des_add)
        val dateEditText: EditText = view.findViewById(R.id.date_add)
       // val dateButton: ImageView = view.findViewById(R.id.date_button_add)
        val addButton: Button = view.findViewById(R.id.add_button)

        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val des = desEditText.text.toString()
            val date = dateEditText.text.toString()

               todolistViewModel.addItem(title,des, false ,date)
            }


       fun EditText.transformIntoDatePicker(context: Context, format: String, maxDate: Date? = null) {
           isFocusableInTouchMode = false
            isClickable = true
            isFocusable = false

            val myCalendar = Calendar.getInstance()
            val datePickerOnDataSetListener =
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    myCalendar.set(Calendar.YEAR, year)
                    myCalendar.set(Calendar.MONTH, monthOfYear)
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val time = SimpleDateFormat (format, Locale.UK) // ??????
                    setText(time.format(myCalendar.time))
                }
            dateEditText.setOnClickListener {
                DatePickerDialog(
                    context, datePickerOnDataSetListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)
                ).run {
                    maxDate?.time?.also { datePicker.maxDate = it }
                    show()
                }
            }
        }
    }

        // كيف لما يضغط على الايقون حقت التاريخ يطلع له التقويم ويختار منها وتطلع في التكست
        // كيف اسوي الدوو ديت ولما يسوي شيك انها تمت يتغير لون التكست

        }


