package com.example.homework1.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.homework1.Constants
import com.example.homework1.R
import com.example.homework1.databinding.ActivityAuthBinding
import com.example.homework1.presentation.ui.main.MainActivity
import com.example.homework1.retrofit.WebRequestListener
import com.example.homework1.retrofit.model.AuthUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
                    getString(R.string.empty_field_email_error)


                binding.passwordEditText.length() == 0 -> binding.passwordEditText.error =
                    "field should be filled"          // TODO: use resources

                binding.passwordEditText.length() < 8 -> binding.passwordEditText.error =
                    "password should be at least 8 symbols"

                else -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        val retrofit =registerUser()
                        val requestListener =retrofit.create(WebRequestListener::class.java)
                       val response=  requestListener.authorizeUser(AuthUser(binding.emailEditText.text.toString(),binding.passwordEditText.text.toString(),null,null,null,null,null,null,null,null,null,null))
                        runOnUiThread {
                            if (response.status=="success"){
                                val intent =Intent(this@AuthActivity,MainActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }






                }
            }
        }else{ binding.emailEditText.error =getString(R.string.invalid_email_error)}

    }
    fun registerUser():Retrofit{
        val interceptor =HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit =Retrofit.Builder().baseUrl("http://178.63.9.114:7777/api/").client(client).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

}




