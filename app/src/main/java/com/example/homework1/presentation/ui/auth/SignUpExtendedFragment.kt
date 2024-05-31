package com.example.homework1.presentation.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.homework1.R
import com.example.homework1.databinding.FragmentSignUpExtendedBinding
import com.example.homework1.retrofit.WebRequestListener
import com.example.homework1.retrofit.model.EditUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class SignUpExtendedFragment : Fragment() {
  private lateinit var binding:FragmentSignUpExtendedBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpExtendedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       editUserData()
    }
    private fun editUserData(){
      val retrofit =  AuthActivity().registerUser()
       val requestListener= retrofit.create(WebRequestListener::class.java)
        CoroutineScope(Dispatchers.IO).launch{
            val response = requestListener.editUser(EditUser(binding.textFieldUsername.text.toString(),binding.textFieldPhone.text.toString(),null,null,null,null,null,null,null,))
            if (response.status =="success"){
                binding.buttonForward.setOnClickListener {
                    findNavController().navigate(R.id.action_signUpExtendedFragment_to_hostPagerFragment)
                }
            }

        }

    }


}