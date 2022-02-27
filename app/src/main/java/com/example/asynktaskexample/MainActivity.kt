package com.example.asynktaskexample

// Example taken from "Alternative 1" https://www.geeksforgeeks.org/alternatives-for-the-deprecated-asynctask-in-android/
//
// We used the same example as we used for AsyncTask.
// Here the executor will execute the task and as soon as the
// desired results are available, UI changes are made using a handler.

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private val myExecutor = Executors.newSingleThreadExecutor()
    private val myHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView = findViewById<TextView>(R.id.textView)
        val myInput = 55

        doMyTask(myTextView, myInput)
    }

    private fun doMyTask(textView: TextView, input: Int){
        myExecutor.execute {
            val result = input.toString()
            myHandler.post {
                textView.text = result
            }
        }
    }
}