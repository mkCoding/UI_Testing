package com.example.ui_testing

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create references for each component on screen
        val button = findViewById<ExtendedFloatingActionButton>(R.id.efabPrintGreeting)
        val enteredValue = findViewById<EditText>(R.id.etEnterName)
        val display = findViewById<TextView>(R.id.tvDisplayResult)

        //add functionality
        button.setOnClickListener {
            if(enteredValue.text.isNotEmpty()){
                display.text = "Hello ${enteredValue.text} hope you're having a great day"
            }else{ display.text = "Please enter in a valid name"

            }
        }
    }
}