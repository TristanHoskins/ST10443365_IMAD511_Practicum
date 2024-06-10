package com.example.st10443365_imad511_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class mscreen2 : AppCompatActivity() {
    //declare each data the users inserts as changeable
    private lateinit var Day: EditText
    private lateinit var Min: EditText
    private lateinit var Max: EditText
    private lateinit var Weatherconditions: EditText
    //groups the data to link it to the next screens table
    private val screenData = mutableListOf<Map<String, Any>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mscreen2)

        Day = findViewById(R.id.editTextText)
        Min = findViewById(R.id.editTextNumber)
        Max = findViewById(R.id.editTextNumber2)
        Weatherconditions = findViewById(R.id.editText)

//buttons are declared
        val button3: Button = findViewById(R.id.button3)
        val button6: Button = findViewById(R.id.button6)
        val button5: Button = findViewById(R.id.button5)
        val button4: Button = findViewById(R.id.button4)
//button 4 is linked to array average
        button4.setOnClickListener{
          calculateAverage() }
//button 6 function to exit page
            button6.setOnClickListener {
            finish()
        }
            button3.setOnClickListener {
                addScreenData()
            }
//button 5 intent to add data to next screen
            button5.setOnClickListener {
                val intent = Intent(this, DetailedViewScreen::class.java)
                intent.putExtra("screenData", ArrayList(screenData))
                startActivity(intent)
            }
        }
    //average arry function
    private fun calculateAverage() {
        //loop structure
        val min = Min.text.toString().toIntOrNull() ?: 0
        val max = Max.text.toString().toIntOrNull() ?: 0

        val values = listOf(min, max)
        val sum = values.sum()
        val count = values.count { it != 0 }

        val average = if (count > 0) sum / count.toDouble() else 0.0
        val textView7: TextView = findViewById(R.id.textView7)
        textView7.text = "Average: $average"
    }
    //screendata array
        private fun addScreenData() {
            val Day = Day.text.toString()
            val Min = Min.text.toString().toIntOrNull() ?: 0
            val Max = Max.text.toString().toIntOrNull() ?: 0
            val Weatherconditions = Weatherconditions.text.toString()
        //if function to ensure data clears once added

            if (Day.isNotEmpty() && (Min > 0 || Max > 0)) {
                val entry = mapOf(
                    "Day" to Day,
                    "Min" to Min,
                    "Max" to Max,
                    "Weatherconditions" to Weatherconditions

                )


                screenData.add(entry)
                clearInputFields()
            }
                    else {
                    Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_LONG).show()
            }
        }


                private fun clearInputFields() {
                    Day.text.clear()
                    Min.text.clear()
                    Max.text.clear()
                    Weatherconditions.text.clear()
                }


            }






