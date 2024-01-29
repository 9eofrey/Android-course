package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.homework1.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity() {
    private lateinit var navController:NavController
    private val binding: ActivityHostBinding by lazy{
        ActivityHostBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
    }

    override fun onSupportNavigateUp(): Boolean {
        navController= findNavController(R.id.fragmentContainerView)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}