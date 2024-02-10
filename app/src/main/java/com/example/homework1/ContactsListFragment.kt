package com.example.homework1

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework1.databinding.AlertDialogBinding
import com.example.homework1.databinding.FragmentContactsListBinding


class ContactsListFragment : Fragment() {
    private lateinit var binding: FragmentContactsListBinding
    private lateinit var alertBinding:AlertDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentContactsListBinding.inflate(inflater,container,false)
        binding.recycleViewContacts.layoutManager =LinearLayoutManager(context)
        val items = mutableListOf<Item>(Item(R.drawable.ic_launcher_background,"Petro"))
        val adapter = Adapter(items)
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
                Log.d("clicked","clicked")
                saveContact(items)
                val name = alertBinding.editTextUsername.text.toString()
                dialog.cancel()
            }
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }
    }
    fun saveContact(items:MutableList<Item>){
        items.add(Item(R.drawable.ic_launcher_background,alertBinding.editTextUsername.text.toString()))
        val position=   items.indexOfLast { Item->true }
        binding.recycleViewContacts?.adapter?.notifyItemInserted(position)


    }








}