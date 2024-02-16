package com.example.homework1.fragments.detailview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homework1.databinding.FragmentContactBinding

class ContactDetailFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding

    private val args:ContactDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(inflater,container,false)
        binding.navigateBackButton.setOnClickListener{
            it.findNavController().popBackStack()

        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.contactProfileAddress.text = args.address
        binding.contactProfileJob.text=args.career
        binding.contactProfileName.text=args.name

    }


}