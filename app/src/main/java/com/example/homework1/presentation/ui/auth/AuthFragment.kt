package com.example.homework1.presentation.ui.auth


import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.homework1.R
import com.example.homework1.databinding.FragmentAuthBinding
import com.example.homework1.presentation.uitl.ext.singletones.RetrofitInstance
import com.example.homework1.retrofit.model.AuthUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException


class AuthFragment : Fragment() {
    private lateinit var binding: FragmentAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()

    }

    private fun setListeners() {
        with(binding) {
            registerButton.setOnClickListener { onRegisterUser() }
            textSignUpClickable.setOnClickListener {
                Log.d("clicker", "Clicked")
                findNavController().navigate(R.id.action_authFragment_to_loginFragment)
            }
        }


    }

    private fun onRegisterUser() {
        // validation
        if (binding.emailEditText.text!!.matches(Patterns.EMAIL_ADDRESS.toRegex())) {
            when {

                // checking email validation
                binding.emailEditText.text!!.isBlank() -> binding.emailEditText.error =
                    getString(R.string.empty_field_email_error)

                //checking password validation
                binding.passwordEditText.text!!.isBlank() -> binding.passwordEditText.error =
                    getString(R.string.empty_field_password_error)

                binding.passwordEditText.length() < 8 -> binding.passwordEditText.error =
                    getString(R.string.invalid_length_password_error)
                // requesting server for authentication
                else -> {
                    fetchData()
                }
            }
        } else {
            binding.emailEditText.error = getString(R.string.invalid_email_error)
        }
    }


    private fun fetchData() {
        lifecycleScope.launch {
            runCatching {
                withContext(Dispatchers.IO){
                    RetrofitInstance.api.authorizeUser(
                        AuthUser(
                            binding.emailEditText.text.toString(),
                            binding.passwordEditText.text.toString(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                        )
                    )
                }

            }.onSuccess {
                findNavController().navigate(R.id.action_authFragment_to_signUpExtendedFragment)


            }.onFailure { exception ->
                when (exception) {
                    is IOException ->
                        Toast.makeText(
                            context,
                            "check internet connection", Toast.LENGTH_LONG
                        ).show()

                    is HttpException ->
                        Toast.makeText(
                            context,
                            "server error", Toast.LENGTH_LONG
                        ).show()


                }
            }

        }

    }
}









