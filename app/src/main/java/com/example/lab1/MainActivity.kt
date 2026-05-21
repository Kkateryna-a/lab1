package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etQuestion = findViewById<EditText>(R.id.etQuestion)
        val rgDifficulty = findViewById<RadioGroup>(R.id.rgDifficulty)
        val rgType = findViewById<RadioGroup>(R.id.rgType)
        val btnOk = findViewById<Button>(R.id.btnOk)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnOk.setOnClickListener {
            val questionText = etQuestion.text.toString().trim()
            val selectedDifficultyId = rgDifficulty.checkedRadioButtonId
            val selectedTypeId = rgType.checkedRadioButtonId

            if (questionText.isEmpty() || selectedDifficultyId == -1 || selectedTypeId == -1) {
                Toast.makeText(this, "Будь ласка, заповніть всі дані та оберіть опції", Toast.LENGTH_SHORT).show()
            } else {
                val selectedDifficulty = findViewById<RadioButton>(selectedDifficultyId).text
                val selectedType = findViewById<RadioButton>(selectedTypeId).text

                val resultString = """
                    Питання: $questionText
                    Складність: $selectedDifficulty
                    Тип: $selectedType
                """.trimIndent()

                tvResult.text = resultString
            }
        }
    }
}