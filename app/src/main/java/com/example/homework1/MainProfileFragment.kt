package com.example.homework1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homework1.R
import com.example.homework1.databinding.FragmentMainProfileBinding
import com.example.homework1.ext.imageLibs
import com.example.homework1.model.AuthViewModel
import java.util.Locale

class MainProfileFragment : Fragment() {
    private lateinit var binding: FragmentMainProfileBinding
    private val viewModel:AuthViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainProfileBinding.inflate(inflater, container, false)
        Log.d("Mytag","value ${viewModel.email.value.toString()}")
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileImage.imageLibs("https://static.thenounproject.com/png/3237155-200.png")
         viewModel.email.observe(activity as LifecycleOwner){
            binding.profileNameText.text = it
        }

    }


    private fun setUserName(email: String):String {
        var str = ""

        if (email.contains(".")) {
            val elements = email.split(".")
            elements.forEach {
                val tmp = it.replaceFirstChar { ch ->
                    if (ch.isLowerCase()) ch.titlecase(Locale.getDefault()) else ch.toString()
                }
                str +="$tmp "
            }
            str.trim()
        } else {
            str = email
        }

        return str
    }


}