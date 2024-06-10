package com.example.homework1.presentation.ui.login

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework1.R
import com.example.homework1.databinding.FragmentLoginBinding
import com.example.homework1.presentation.ui.auth.AuthActivity
import com.example.homework1.retrofit.WebRequestListener
import com.example.homework1.retrofit.model.LoginUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun loginUser(){
      val retrofit=  AuthActivity().getRetrofit()
       val requestListener = retrofit.create(WebRequestListener::class.java)
       CoroutineScope(Dispatchers.IO).launch {
           requestListener.loginUser(LoginUser(binding.textInputEditTextEmail.text.toString(),binding.textInputEditTextPassword.text.toString()))
       }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       when{
           binding.textInputEditTextEmail.text!!.isBlank() -> binding.textInputEditTextEmail.error =
                getString(R.string.empty_field_email_error)
           binding.textInputEditTextPassword.text!!.isBlank()->binding.textInputLayoutPassword.error=
               getString(R.string.empty_field_password_error)
           binding.textInputEditTextPassword.length()<8 -> binding.textInputLayoutPassword.error =
                getString(R.string.empty_field_password_error)

           else->{
               loginUser()

           }
       }



    }

}