package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var weightEditText:EditText
    lateinit var heightEditText:EditText
    lateinit var calculateButton:Button
    lateinit var exitButton:Button
    lateinit var bmiResultTextView:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        weightEditText=findViewById(R.id.weightEditText)
        heightEditText=findViewById(R.id.heightEditText)
        calculateButton=findViewById(R.id.calculateButton)
        exitButton=findViewById(R.id.exitButton)
        bmiResultTextView=findViewById(R.id.bmiResultTextView)



        calculateButton.setOnClickListener {
                calculateBMI()
            }

            exitButton.setOnClickListener {
                showExitDialog()
            }
        }

        private fun calculateBMI() {
            val weight = weightEditText.text.toString().toFloatOrNull()
            val height = heightEditText.text.toString().toFloatOrNull()

            if (weight != null && height != null) {
                val bmi = calculateBMIValue(weight, height)
                val bmiStatus = getBMIStatus(bmi)
                bmiResultTextView.text = String.format("Your BMI: %.2f\n%s", bmi, bmiStatus)
            } else {
                Toast.makeText(this, "Please enter valid weight and height", Toast.LENGTH_SHORT).show()
            }
        }

        private fun calculateBMIValue(weight: Float, height: Float): Float {
            return weight / (height * height)
        }

        private fun getBMIStatus(bmi: Float): String {
            return when {
                bmi < 18.5 -> "Underweight"
                bmi >= 18.5 && bmi < 25 -> "Normal weight"
                bmi >= 25 && bmi < 30 -> "Overweight"
                else -> "Obese"
            }
        }

        private fun showExitDialog() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Exit")
            builder.setMessage("Are you sure you want to exit?")
            builder.setPositiveButton("Yes") { _, _ ->
                // If user clicks "Yes", close the app
                finish()
            }
            builder.setNegativeButton("No") { dialogInterface, _ ->
                // If user clicks "No", dismiss the dialog
                dialogInterface.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

}




