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

const val KEY_NAME = "ac_name"
const val keyPass = "ac_pass"
const val keyBool = "is_checked"


class AuthActivity : AppCompatActivity() {

    private val sharedPref: SharedPreferences by lazy {
        getSharedPreferences(Constants.MY_PREFS, MODE_PRIVATE)
    }
    private val binding: ActivityAuthBinding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        handleStartActivity()
        setListeners()
    }

    private fun handleStartActivity() {
        if (getDataOfRememberMe()) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.USERNAME, getAcName())
            startActivity(intent)
        }
    }

    private fun setListeners() {
        binding.registerButton.setOnClickListener { onRegisterUser() }

    }

    //Todo : export validation to another file
    private fun onRegisterUser() { // TODO: read about scope function with
        // setting actions on click

        //for validation
        if ("sdfsf".matches(Patterns.EMAIL_ADDRESS.toRegex())) {

        }
        when {
            // checking validation
            binding.emailEditText.length() == 0 -> binding.emailEditText.error =
                getString(R.string.email_error)

            binding.passwordEditText.length() == 0 -> binding.passwordEditText.error =
                "field should be filled"          // TODO: use resources

            binding.passwordEditText.length() < 8 -> binding.passwordEditText.error =
                "password should be at least 8 symbols"

            else -> {
                // putting data into MainActivity

                viewModel.addData(binding.emailEditText.text.toString())

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(Constants.USERNAME, binding.emailEditText.text.toString())
                startActivity(intent)
//                if (binding.rememberCheckbox.isChecked) {
//                    saveData(
//                        binding.emailEditText.text.toString(),
//                        binding.passwordEditText.text.toString(),
//                        true
//                    )
//                    //Log.d("save data", "$isCheck")
            }

//
            // intent.putExtra(Constants.username, binding.emailEditText.text.toString())
            //   intent.putExtra(Constants.isChecked, isCheck) // TODO: need?
            // startActivity(intent)
            // }
        }
    }

    private fun saveData(acName: String, acPassword: String, is_checked: Boolean) {
        sharedPref.edit()
            .putString(KEY_NAME, acName)
            .putString(keyPass, acPassword)
            .putBoolean(keyBool, is_checked)
            .apply()
    }

    private fun getAcName() = sharedPref.getString(KEY_NAME, " ")


    private fun getDataOfRememberMe(): Boolean { // TODO: change name
        return sharedPref.getBoolean(keyBool, false)
    }

    private fun getAcPass(): String? {
        return sharedPref.getString(keyPass, " ")
    }
}