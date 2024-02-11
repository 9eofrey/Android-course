package com.example.homework1.fragments.contacts

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework1.fragments.contacts.adapter.Adapter
import com.example.homework1.model.Contact
import com.example.homework1.R
import com.example.homework1.databinding.AlertDialogBinding
import com.example.homework1.databinding.FragmentContactsListBinding


class ContactsFragment : Fragment() {
    private lateinit var binding: FragmentContactsListBinding
    private lateinit var alertBinding: AlertDialogBinding
    private val viewModel: ContactViewModel by viewModels()
    lateinit var  adapter: Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentContactsListBinding.inflate(inflater, container, false)
        binding.recycleViewContacts.layoutManager = LinearLayoutManager(context)
        val onDelete:(Int)->Unit = {position->
            viewModel.deleteOnPosition(position)
        }
        adapter = Adapter(viewModel.contacts.value!!,onDelete)
        binding.recycleViewContacts.adapter = adapter

        binding.buttonBackNavigation.setOnClickListener {
            it.findNavController().popBackStack()
        }
        alertBinding = AlertDialogBinding.inflate(layoutInflater)
        binding.buttonAddContact.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.alert_dialog, null)
            val dialog = AlertDialog.Builder(context).setView(view).show()
            alertBinding = AlertDialogBinding.bind(view)

            alertBinding.buttonSaveContact.setOnClickListener {
                Log.d("clicked", "clicked")
                val contact = Contact(
                    R.drawable.ic_launcher_background,
                    alertBinding.editTextUsername.text.toString(),
                    alertBinding.editTextCareer.text.toString(),
                    alertBinding.editTextAddress.text.toString()
                )
                viewModel.addData(contact)


                dialog.cancel()
            }
        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }
        setObservers()

    }

    private fun setObservers() {
        viewModel.contacts.observe(viewLifecycleOwner){
            adapter.refreshData(it)
        }
    }


}