package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class onBoardingScreenActivity : AppCompatActivity() {
    private lateinit var btnNext:Button
    lateinit var etInputName:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_screen)

        btnNext=findViewById(R.id.btnNext)
        etInputName=findViewById(R.id.etInputName)

            btnNext.setOnClickListener {
                val username = etInputName.text.toString()

                if (username.isEmpty()){
                    Toast.makeText(this,"Please your enter name",Toast.LENGTH_LONG).show()
                }else {
                    val intent = Intent(this, enteredInfoScreenActivity::class.java)
                    intent.putExtra("message_key", username)
                    startActivity(intent)
                    finish()
            }

        }

    }
}