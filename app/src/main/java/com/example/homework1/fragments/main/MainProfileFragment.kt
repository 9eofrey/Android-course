package com.example.homework1.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homework1.R
import com.example.homework1.databinding.FragmentMainProfileBinding
import java.util.Locale

class MainProfileFragment : Fragment() {
    private lateinit var binding: FragmentMainProfileBinding
    private var getemail = ""
    private val args: MainProfileFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainProfileBinding.inflate(inflater, container, false)


        binding.viewContactsButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainProfileFragment_to_contactsListFragment)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getemail = args.email
        setUserName(getemail)
    }


    private fun setUserName(email: String) {
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

        binding.profileNameText!!.text = str
    }


}