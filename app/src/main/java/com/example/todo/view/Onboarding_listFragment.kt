package com.example.todolistapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todolistapp.model.ToDoListModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Onboarding_listFragment : Fragment() {

    private val todolistTask = mutableListOf<ToDoListModel>()
  // activityViewModels >>>> object from  TodolistViewModel
    private val todolistViewModel: ToDoListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todolistRecyclerView: RecyclerView = view.findViewById(R.id.recyclerview_app)
        val addFloatingActionButton: FloatingActionButton =
            view.findViewById(R.id.floatingActionButton4)

        val todolistAdapter = ToDoListAdapter(todolistTask, todolistViewModel)

        todolistRecyclerView.adapter = todolistAdapter


        todolistViewModel.todolisttask.observe(viewLifecycleOwner, Observer {
            it?.let { task ->
                todolistTask.clear()
                todolistTask.addAll(task)
                todolistAdapter.notifyDataSetChanged()
            }
        })
        addFloatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_onboarding_listFragment_to_addFragment)
        }
    }
}