package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter.AllCaps
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textuser = findViewById<TextView>(R.id.profile_name_text)

        val intent = intent.getStringExtra(Constants.username)

val parsed = intent?.substringBefore("@")
val parsedName= intent!!.substringBefore(".").capitalize()
val parsedSurname =parsed!!.substringAfter(".").capitalize()

val parsedAccountName= parsedName +" "+ parsedSurname

        textuser.text= parsedAccountName


    }
}