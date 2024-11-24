package com.example.homework1.presentation.ui.login


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.homework1.R
import com.example.homework1.databinding.FragmentLoginBinding

import com.example.homework1.presentation.uitl.ext.singletones.RetrofitInstance

import com.example.homework1.retrofit.model.LoginUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            buttonLogin.setOnClickListener {
                when{
                    binding.textInputEditTextEmail.text!!.isBlank() -> binding.textInputEditTextEmail.error =
                        getString(R.string.empty_field_email_error)
                    binding.textInputEditTextPassword.text!!.isBlank()->binding.textInputLayoutPassword.error=
                        getString(R.string.empty_field_password_error)
                    binding.textInputEditTextPassword.length()<8 -> binding.textInputLayoutPassword.error =
                        getString(R.string.empty_field_password_error)

                    else->{
                        CoroutineScope(Dispatchers.IO).launch {
                            runCatching {
                                RetrofitInstance.api.loginUser(LoginUser(binding.textInputEditTextEmail.text.toString(),binding.textInputEditTextPassword.text.toString()))
                            }.onSuccess {
                                Log.d("response","success login")
                                findNavController().navigate(R.id.action_loginFragment_to_hostPagerFragment)
                            }.onFailure {
                                exception -> when(exception){
                                    is IOException -> requireActivity().runOnUiThread { Toast.makeText(
                                        context, "check your internet connection",Toast.LENGTH_LONG
                                    ).show() }
                                    is HttpException -> requireActivity().runOnUiThread { Toast.makeText(
                                        context, "server error",Toast.LENGTH_LONG
                                    ).show() }
                                }
                            }
                        }

                    }
                }
            }
            clickableTextViewSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_authFragment)
            }
        }




    }

}