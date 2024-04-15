package com.example.homework1.presentation.ui.main.contactDeteil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homework1.databinding.FragmentContactBinding
import com.example.homework1.presentation.uitl.ext.imageLibs

class ContactDetailFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    private val args: ContactDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(inflater, container, false)

        binding.navigateBackButton.setOnClickListener {
            it.findNavController().popBackStack()
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            contactProfileImage.imageLibs("https://i.pinimg.com/736x/fc/27/fb/fc27fb81e77cc56ba4ed981d7801ceb9.jpg")
            contactProfileAddress.text = args.data.address
            contactProfileName.text = args.data.name
            contactProfileJob.text = args.data.job

        }


    }


}