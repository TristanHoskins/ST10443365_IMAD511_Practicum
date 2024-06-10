package com.example.st10443365_imad511_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class mscreen2 : AppCompatActivity() {
    private lateinit var Day: EditText
    private lateinit var Min: EditText
    private lateinit var Max: EditText
    private lateinit var Weatherconditions: EditText
    private val screenData = mutableListOf<Map<String, Any>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mscreen2)

        Day = findViewById(R.id.editTextText)
        Min = findViewById(R.id.editTextNumber)
        Max = findViewById(R.id.editTextNumber2)
        Weatherconditions = findViewById(R.id.editText)

        val button3: Button = findViewById(R.id.button3)
        val button6: Button = findViewById(R.id.button6)
        val button5: Button = findViewById(R.id.button5)
        val button4: Button = findViewById(R.id.button4)

        button4.setOnClickListener{
          calculateAverage() }

            button6.setOnClickListener {
            finish()
        }
            button3.setOnClickListener {
                addScreenData()
            }

            button5.setOnClickListener {
                val intent = Intent(this, DetailedViewScreen::class.java)
                intent.putExtra("screenData", ArrayList(screenData))
                startActivity(intent)
            }
        }
    private fun calculateAverage() {
        val min = Min.text.toString().toIntOrNull() ?: 0
        val max = Max.text.toString().toIntOrNull() ?: 0
        val average = (min + max) / 2.0
        val textView7: TextView = findViewById(R.id.textView7)
        textView7.text = "Average: $average"
    }
        private fun addScreenData() {
            val Day = Day.text.toString()
            val Min = Min.text.toString().toIntOrNull() ?: 0
            val Max = Max.text.toString().toIntOrNull() ?: 0
            val Weatherconditions = Weatherconditions.text.toString()

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
        }


                private fun clearInputFields() {
                    Day.text.clear()
                    Min.text.clear()
                    Max.text.clear()
                    Weatherconditions.text.clear()
                }


            }






