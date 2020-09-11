package com.example.madlevel2task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.QuizQuestionBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class QuestionAdapter (private val questions : List<Question>) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = QuizQuestionBinding.bind(itemView)

        fun bind(question: Question) {
            binding.QuestionTv.text = question.questionText;

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.quiz_question , parent , false)
        )
    }

    override fun getItemCount(): Int {
        return this.questions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(questions[position]);
    }
}