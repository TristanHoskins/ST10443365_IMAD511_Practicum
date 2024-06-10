package com.example.st10443365_imad511_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declared button as variable

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        //created button function , intent used to link button to next page

        button1.setOnClickListener {
            val intent = Intent(this, mscreen2::class.java)

            startActivity(intent)
        }
        //button function exit app
        button2.setOnClickListener {
            finish()
        }
    }
}
