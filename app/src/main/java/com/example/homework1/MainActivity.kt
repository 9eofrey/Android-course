package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() { // TODO: use binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra(Constants.username) ?: ""
        setUserName(email)
    }

    private fun setUserName(email: String) {
        var textuser = findViewById<TextView>(R.id.profile_name_text) // TODO: binding

        val elements = email.substringBefore("@").split(".")
        val name = elements[0].substringBefore(".")
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val lastName = elements[1].substringAfter(".")
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

        val parsedAccountName = "$name $lastName"

        textuser.text = parsedAccountName
    }

}