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
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val questions = arrayListOf<Question>(
        Question("A \'val\' and \'var\' are the same" , false),
        Question("Mobile Application Development grants 12ECTS." , true),
        Question("A Unit in Kotlin corresponds to a void in Java" , true),
        Question("In Kotlin \'When\' Replaces the \'switch\' operator in Java" , true)
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
        // Initialize the recycler view with a linear layout manager, adapter
        binding.rvQuestions.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        binding.rvQuestions.adapter = questionAdapter
        binding.rvQuestions.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        createItemTouchHelper().attachToRecyclerView(rvQuestions)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {


        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                //is true
                if (direction == 8){
                    //if correct show is correct else its incoorect
                    if (questions[position].isCorrect){
                        Snackbar.make(cl, "Correct", Snackbar.LENGTH_SHORT).show()
                    }else {
                        Snackbar.make(cl, "incorrect", Snackbar.LENGTH_SHORT).show()
                    }
                }
                if (direction == 4){
                    if (!questions[position].isCorrect){
                        Snackbar.make(cl, "Correct", Snackbar.LENGTH_SHORT).show()
                    }else {
                        Snackbar.make(cl, "incorrect", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        }
        return ItemTouchHelper(callback)
    }
}
