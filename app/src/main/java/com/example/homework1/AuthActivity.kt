package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val textViewName = findViewById<EditText>(R.id.email_edit_text)
        val textPassword= findViewById<EditText>(R.id.password_edit_text)

        val registerButton = findViewById<Button>(R.id.register_button)

        registerButton.setOnClickListener {
            // setting actions on click
             when {
                 // checking validation
                textViewName.length() == 0 -> textViewName.setError("field should be filled")
                textPassword.length()==0 ->   textPassword.setError("field should be filled")
                 textPassword.length()<8 -> textPassword.setError("password should be at least 8 symbols")
                else -> {
                    // putting data into MainActivity
                    val intent = Intent(this, MainActivity::class.java)

                    intent.putExtra(Constants.username, textViewName.text.toString())
                    startActivity(intent)
                }
            }



        }


    }


}