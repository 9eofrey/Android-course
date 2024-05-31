package com.example.homework1.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.homework1.R
import com.example.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { // TODO: use binding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onSupportNavigateUp(): Boolean {
        navController= findNavController(R.id.fragmentContainerView)
        return navController.navigateUp() || super.onSupportNavigateUp()


    }



}