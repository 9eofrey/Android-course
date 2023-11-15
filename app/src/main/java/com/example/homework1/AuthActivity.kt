package com.example.homework1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.util.jar.Attributes.Name

const val keyName = "ac_name"
const val keyPass = "ac_pass"
const val keyBool = "is_checked"


class AuthActivity : AppCompatActivity() {
   lateinit var sharedPref:SharedPreferences
    var isCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        sharedPref= getSharedPreferences("main", MODE_PRIVATE)

        val textViewName = findViewById<EditText>(R.id.email_edit_text)
        val textPassword = findViewById<EditText>(R.id.password_edit_text)
        val autoLogin = findViewById<CheckBox>(R.id.remember_checkbox)
            val registerButton = findViewById<Button>(R.id.register_button)
        val Name =getAcName()
        isCheck = getBool()
        if(isCheck==true){
           val int =Intent(this, MainActivity::class.java)
            int.putExtra(Constants.username,Name)
            startActivity(int)
        }


        autoLogin.setOnCheckedChangeListener { _, isChecked ->
            this.isCheck =isChecked
            Log.d("aaaa", "isChecked $isChecked")



        }


        registerButton.setOnClickListener {
            // setting actions on click

            when {
                // checking validation
                textViewName.length() == 0 -> textViewName.error = "field should be filled"
                textPassword.length() == 0 -> textPassword.error = "field should be filled"
                textPassword.length() < 8 -> textPassword.error = "password should be at least 8 symbols"

                else -> {
                    // putting data into MainActivity

                    val intent = Intent(this, MainActivity::class.java)
                    if (isCheck==true){
                        saveData(textViewName.text.toString(), textPassword.text.toString(),isCheck)
                        Log.d("save data","$isCheck")
                    }


                    intent.putExtra(Constants.username,textViewName.text.toString())
                    intent.putExtra(Constants.isChecked, isCheck)
                    startActivity(intent)
                }
            }


        }


    }
    fun saveData(ac_name: String, ac_pass: String,is_checked:Boolean) {

        val editor = sharedPref.edit()
        editor.putString(keyName, ac_name)
        editor.putString(keyPass, ac_pass)
        editor.putBoolean(keyBool,is_checked)
        editor.apply()


    }

    fun getAcName(): String? {

        return sharedPref.getString(keyName, " ")


    }
    fun getBool():Boolean{
        return sharedPref.getBoolean(keyBool,false)
    }

    fun getAcPass(): String? {

        return sharedPref.getString(keyPass, " ")

    }



}