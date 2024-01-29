package com.example.homework1

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.homework1.databinding.FragmentMainProfileBinding
import java.util.Locale

class MainProfileFragment : Fragment() {
    private lateinit var binding: FragmentMainProfileBinding
    private var getemail=""
    private val args:MainProfileFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainProfileBinding.inflate(inflater,container,false)

        binding.viewContactsButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainProfileFragment_to_contactsListFragment)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getemail = args.email
        //setUserName(getemail)
    }



private fun setUserName(email: String) {
    val elements = email.substringBefore("@").split(".")
    val name = elements[0].substringBefore(".")
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    val lastName = elements[1].substringAfter(".")
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    val parsedAccountName = "$name $lastName"

    binding.profileNameText!!.text = parsedAccountName
}


}