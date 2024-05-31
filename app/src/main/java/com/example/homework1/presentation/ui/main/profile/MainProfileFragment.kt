package com.example.homework1.presentation.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.homework1.Constants
import com.example.homework1.databinding.FragmentMainProfileBinding
import com.example.homework1.presentation.ui.auth.AuthViewModel
import com.example.homework1.presentation.ui.main.pager.HostPagerFragment
import com.example.homework1.presentation.ui.main.pager.HostPagerFragmentArgs
import com.example.homework1.presentation.uitl.ext.imageLibs
import java.util.Locale


class MainProfileFragment : Fragment() {
    private lateinit var binding: FragmentMainProfileBinding
    private val viewModel: AuthViewModel by viewModels()
    private val args:HostPagerFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainProfileBinding.inflate(inflater, container, false)
        Log.d("Mytag", "value ${viewModel.email.value.toString()}")

        binding.viewContactsButton.setOnClickListener {
            (parentFragment as HostPagerFragment).getViewPager().currentItem = 1
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            profileImage.imageLibs("https://static.thenounproject.com/png/3237155-200.png")
         //   val email = activity?.intent?.getStringExtra().orEmpty()

            binding.profileNameText.text = args.name
        }
    }

    //Todo : export logic to another file
//    private fun setUserName(email: String): String {
//        var str = ""
//
//        if (email.contains(".")) {
//            val elements = email.split(".")
//            elements.forEach {
//                val tmp = it.replaceFirstChar { ch ->
//                    if (ch.isLowerCase()) ch.titlecase(Locale.getDefault()) else ch.toString()
//                }
//                str += "$tmp "
//            }
//            str.trim()
//        } else {
//            str = email
//        }
//
//        return str
//    }


}