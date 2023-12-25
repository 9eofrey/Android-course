package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.homework1.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListeners()
        val email = intent.getStringExtra(Constants.username) ?:""
        setUserName(email)
        Glide.with(this)

            .load("https://img.freepik.com/free-photo/the-red-or-white-cat-i-on-white-studio_155003-13189.jpg?size=626&ext=jpg&ga=GA1.1.1880011253.1699747200&semt=ais")
            .centerCrop()
            .into(binding.profileImage!!)
    }

    private fun setUserName(email: String) {
        val elements = email.substringBefore("@").split(".")
        val name = elements[0].substringBefore(".")
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val lastName = elements[1].substringAfter(".")
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

        val parsedAccountName = "$name $lastName"

       binding.profileNameText!!.text = parsedAccountName
    }

    private fun setListeners(){
        binding.viewContactsButton?.setOnClickListener { intents() }


    }
    private fun intents(){
        val intent = Intent(this, ContactsActivity::class.java)
        startActivity(intent)
    }

}