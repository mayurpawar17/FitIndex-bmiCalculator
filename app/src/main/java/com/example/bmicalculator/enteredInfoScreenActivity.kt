package com.example.bmicalculator

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class enteredInfoScreenActivity : AppCompatActivity() {

    lateinit var btnCalculate:Button
    lateinit var exitBtn:ImageView
    lateinit var tvUsername:TextView
    lateinit var etHeight:EditText
    lateinit var etWeight:EditText
    lateinit var textViewResult:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entered_info_screen)

        btnCalculate=findViewById(R.id.btnCalculate)
        exitBtn=findViewById(R.id.exitBtn)

        tvUsername=findViewById(R.id.tvUsername)
        etHeight=findViewById(R.id.etHeight)
        etWeight=findViewById(R.id.etWeight)
        textViewResult=findViewById(R.id.textViewResult)


        val intent = intent
        val username = intent.getStringExtra("message_key")
        tvUsername.text = username
        tvUsername.setText("Hi $username")



        btnCalculate.setOnClickListener {
            val height=etHeight.text.toString()
            val weight=etWeight.text.toString()
            if(height.isEmpty()){

                Toast.makeText(this,"Enter Height",Toast.LENGTH_SHORT).show()


            }else if(weight.isEmpty()){

                Toast.makeText(this,"Enter Weight",Toast.LENGTH_SHORT).show()

            }else{

                val bmi=weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))
                val bmiToDigit =String.format("%.2f",bmi).toFloat()
                calculateBMI(bmiToDigit)

            }

            }
            exitBtn.setOnClickListener {
                showExitDialog()
            }



    }

    private fun calculateBMI(bmi: Float){
        textViewResult.text=bmi.toString()
    }




    private fun showExitDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure you want to exit?")
        builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
            // If user clicks "Yes", close the app
            finish()
        }
        builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
            // If user clicks "No", dismiss the dialog
            dialogInterface.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

}