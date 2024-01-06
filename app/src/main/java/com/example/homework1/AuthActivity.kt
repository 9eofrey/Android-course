package com.example.homework1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.example.homework1.databinding.ActivityAuthBinding
import org.w3c.dom.Text

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        handleStartActivity()
        setListeners()
    }

    private fun handleStartActivity() {
        if (getDataFromRememberMe()) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.username, getAcName())
            startActivity(intent)
        }
    }

    private fun setListeners() {
        binding.registerButton.setOnClickListener { onRegisterUser() }

    }


    private fun onRegisterUser() {
        // setting actions on click
        when {
            // checking validation
            binding.emailEditText.length() == 0 -> binding.emailEditText.error =
                getString(R.string.email_error)

            binding.passwordEditText.length() == 0 -> binding.passwordEditText.error =
                getString(R.string.password_error_field)
            binding.passwordEditText.length() < 8 -> binding.passwordEditText.error =
               getString(R.string.password_error_length)

            else -> {
                // putting data into MainActivity

                val intent = Intent(this, MainActivity::class.java)
                if (binding.rememberCheckbox.isChecked) {
                    saveData(
                        binding.emailEditText.text.toString(),
                        binding.passwordEditText.text.toString(),
                        true
                    )
                    //Log.d("save data", "$isCheck")
                }


                intent.putExtra(Constants.username, binding.emailEditText.text.toString())

                startActivity(intent)
            }
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


    private fun getDataFromRememberMe(): Boolean {
        return sharedPref.getBoolean(keyBool, false)
    }

    private fun getAcPass(): String? {
        return sharedPref.getString(keyPass, " ")
    }

  class CustomButton(context: Context, attrs:AttributeSet):AppCompatButton(context,attrs){
      val paint = Paint()
      init{
          paint.style= Paint.Style.FILL
          paint.color = Color.WHITE

      }
      override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
          super.onMeasure(widthMeasureSpec, heightMeasureSpec)
          val width =  MeasureSpec.getSize(widthMeasureSpec)
          val height = MeasureSpec.getSize(heightMeasureSpec)
          super.setMeasuredDimension(width,height)

      }

      override fun onDraw(canvas: Canvas) {
          super.onDraw(canvas)
          canvas.drawRect(12.2f,12.2f,12.2f,12.2f,paint)

      }






  }

}