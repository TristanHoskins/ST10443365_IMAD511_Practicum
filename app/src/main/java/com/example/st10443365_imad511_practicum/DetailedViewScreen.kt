package com.example.st10443365_imad511_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class DetailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_screen)

        val tableLayout: TableLayout = findViewById(R.id.tableLayout)
        val button7: Button = findViewById(R.id.button7)


        val screenData = intent.getSerializableExtra("screenData") as ArrayList<Map<String, Any>>

        populateSummaryTable(tableLayout, screenData)

//when button 7 is clicked it is linked to go back to previous page
        button7.setOnClickListener {
            val intent = Intent(this, mscreen2::class.java)
            startActivity(intent)
        }
    }

    private fun populateSummaryTable(tableLayout: TableLayout, screenData: List<Map<String, Any>>) {
        // Adding table headers
        val headerRow = TableRow(this)
        headerRow.addView(createTextView("Day"))
        headerRow.addView(createTextView("Min"))
        headerRow.addView(createTextView("Max"))
        headerRow.addView(createTextView("Weatherconditions"))
        tableLayout.addView(headerRow)

        screenData.forEach { entry ->
            val row = TableRow(this)
            row.addView(createTextView(entry["Day"] as String))
            row.addView(createTextView((entry["Min"] as Int).toString()))
            row.addView(createTextView((entry["Max"] as Int).toString()))
            row.addView(createTextView(entry["Weatherconditions"] as String))
            tableLayout.addView(row)
        }
    }
//data is displayed in the text view
    private fun createTextView(text: String): TextView {
        val textView8 = TextView(this)
        textView8.text = text
        return textView8
    }
}
