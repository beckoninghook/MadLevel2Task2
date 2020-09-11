package com.example.madlevel2example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.Question
import com.example.madlevel2task2.QuestionAdapter
import com.example.madlevel2task2.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val questions = arrayListOf<Question>(
        Question("A \'val\' and \'var\' are the same" , false),
        Question("Mobile Application Development grants 12ECTS." , false),
        Question("A Unit in Kotlin corresponds to a void in Java" , false),
        Question("In Kotlin \'When\' Replaces the \'switch\' operator in Java" , false)
    )
    private val questionAdapter = QuestionAdapter(questions)
    // Don't forget to create a binding object as you did in previous assignments.
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }


    fun initViews(){

        // Create an onClickListener associated with the button


        // Initialize the recycler view with a linear layout manager, adapter
        binding.rvQuestions.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        binding.rvQuestions.adapter = questionAdapter
        binding.rvQuestions.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

    }

 


}
