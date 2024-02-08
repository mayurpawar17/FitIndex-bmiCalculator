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
        textSet()



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

    private fun textSet(){
        val text1 =findViewById<TextView>(R.id.text1)
        val text2=findViewById<TextView>(R.id.text2)
        val text3=findViewById<TextView>(R.id.text3)
        val text4=findViewById<TextView>(R.id.text4)
        val text5=findViewById<TextView>(R.id.text5)
        val text6=findViewById<TextView>(R.id.text6)

        val Underweight="Underweight"
        val NormalWeight ="Normal Weight"
        val Pre_obesity =" Pre-obesity"
        val  Obesity_Class_l=" Obesity Class l"
        val  Obesity_Class_ll=" Obesity Class ll"
        val  Obesity_Class_lll=" Obesity Class lll"




        text1.text = "Below 18.5   $Underweight"
        text2.text = "18.5 - 24.9    $NormalWeight"
        text3.text = "25.0 - 29.9    $Pre_obesity"
        text4.text = "30.0 - 34.9   $Obesity_Class_l"
        text5.text = "35.0 - 39.9   $Obesity_Class_ll"
        text6.text = "Above 40    $Obesity_Class_lll"


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