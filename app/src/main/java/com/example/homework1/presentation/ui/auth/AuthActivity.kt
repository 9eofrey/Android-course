package com.example.homework1.presentation.ui.auth

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.homework1.Constants
import com.example.homework1.R
import com.example.homework1.databinding.ActivityAuthBinding
import com.example.homework1.presentation.ui.main.MainActivity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val KEY_NAME = "ac_name"
const val keyPass = "ac_pass"
const val keyBool = "is_checked"


class AuthActivity : AppCompatActivity() {
    private val binding: ActivityAuthBinding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListeners()
    }


    private fun setListeners() {
        binding.registerButton.setOnClickListener { onRegisterUser() }

    }

    //Todo : export validation to another file
    private fun onRegisterUser() { // TODO: read about scope function with
        // setting actions on click

        //for validation
        if (binding.emailEditText.text!!.matches(Patterns.EMAIL_ADDRESS.toRegex())) {
            when {
                // checking validation
                binding.emailEditText.length() == 0 -> binding.emailEditText.error =
                    getString(R.string.email_error)


                binding.passwordEditText.length() == 0 -> binding.passwordEditText.error =
                    "field should be filled"          // TODO: use resources

                binding.passwordEditText.length() < 8 -> binding.passwordEditText.error =
                    "password should be at least 8 symbols"

                else -> {

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra(Constants.USERNAME, binding.emailEditText.text.toString())
                    startActivity(intent)
                }
            }
        }

    }
    private fun registerUser(){
        val interceptor =HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit =Retrofit.Builder().baseUrl("http://178.63.9.114:7777/api/").client(client).addConverterFactory(GsonConverterFactory.create()).build()
    }

}




