package com.example.madlevel2task2

data class Question(
    var questionText : String,
    var isCorrect : Boolean
){
    val QuestionArr = arrayOf(
        Question("A \\'val\\' and \\'var\\' are the same" , false),
        Question("Mobile Application Development grants 12ECTS." , false),
        Question("A Unit in Kotlin corresponds to a void in Java" , false),
        Question("In Kotlin \\'When\\' Replaces the \\'switch\\' operator in Java" , false)
    )
}
