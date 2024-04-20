package com.example.homework1.presentation.ui.main.contactList

import SwipeToDeleteCallback
import android.app.AlertDialog
import android.os.Bundle
import android.os.Parcel

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.R
import com.example.homework1.data.Contact
import com.example.homework1.databinding.AlertDialogBinding
import com.example.homework1.databinding.FragmentContactsListBinding
import com.example.homework1.presentation.ui.main.contactList.adapter.ContactsAdapter
import com.example.homework1.presentation.ui.main.contactList.interfaces.OnContactItemListener
import com.example.homework1.presentation.ui.main.contactList.interfaces.OnMultiselectItemListener
import com.example.homework1.presentation.ui.main.pager.HostPagerFragmentDirections


class ContactsFragment:Fragment() {

   lateinit var binding: FragmentContactsListBinding
    private lateinit var alertBinding: AlertDialogBinding
    private val viewModel: ContactViewModel by viewModels()
    private lateinit var recadapter: ContactsAdapter
    private lateinit var navCont: NavController
    private var itemTouchHelper:ItemTouchHelper? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {


        binding = FragmentContactsListBinding.inflate(inflater, container, false)
        setAdapter()
        setListeners()

        setAlertDialog()
        setItemTouchHelper()

        navCont = findNavController()
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }


    fun showToast() {
        // TODO Implement Toast
    }

    private fun setObservers() {

        viewModel.contacts.observe(viewLifecycleOwner) {
            recadapter.submitList(it)
        }
        viewModel.isSelectedModeOn.observe(viewLifecycleOwner) {
            Log.d("isMultiselect", "Multiselect = $it")
            recadapter.setMultiselectMode(it)

        }

    }

    private fun setListeners() {

        binding.apply {
            buttonBackNavigation.setOnClickListener {
                it.findNavController().popBackStack()
            }
            if (recadapter.isSelectionOn){
                binding.buttonDeleteSelectedContacts.visibility= View.VISIBLE
                binding.buttonDeleteSelectedContacts.setOnClickListener {
                    viewModel.onDeleteSelectedItems()
                }
            }else binding.buttonDeleteSelectedContacts.visibility= View.GONE
        }


    }
    private fun setItemTouchHelper(){
        val callback :SwipeToDeleteCallback
        callback = object :SwipeToDeleteCallback(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteContact(recadapter.currentList[viewHolder.bindingAdapterPosition])
            }
        }
        itemTouchHelper = ItemTouchHelper(callback)
        setSwipeToDelete()
    }

    private fun setSwipeToDelete() {
        if (!recadapter.isSelectionOn) {
            itemTouchHelper?.attachToRecyclerView(binding.recycleViewContacts)
        }else itemTouchHelper?.attachToRecyclerView(null)

    }

    private fun setAdapter() {
        binding.recycleViewContacts.layoutManager = LinearLayoutManager(context)
        recadapter = ContactsAdapter(
            onContactItemListener = object : OnContactItemListener {
                override fun onItemCLick(position: Int, contact: Contact) {
                    val directions =
                        HostPagerFragmentDirections.actionHostPagerFragmentToContactDetailFragment(
                            contact
                        )
                    findNavController().navigate(directions)
                }

                override fun onDeleteItem(contact: Contact) {
                    viewModel.deleteContact(contact)

                }


                override fun onLongItemClick(contact: Contact) {
                    viewModel.onSelectionMode(true)
                    viewModel.onItemSelection(contact)
                }


            },
            onMultiselectItemListener = object : OnMultiselectItemListener {
                override fun onItemSelectionClick(contact: Contact) {
                    viewModel.onItemSelection(contact)
                }

                override fun deleteSelectedContacts() {
                    viewModel.onDeleteSelectedItems()
                }


            }
        )

        binding.recycleViewContacts.adapter = recadapter
    }

    private fun setAlertDialog() {

        alertBinding = AlertDialogBinding.inflate(layoutInflater)
        binding.buttonAddContact.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.alert_dialog, null)
            val dialog = AlertDialog.Builder(context).setView(view).show()
            alertBinding = AlertDialogBinding.bind(view)

            alertBinding.buttonSaveContact.setOnClickListener {
                Log.d("clicked", "clicked")
                val contact = Contact(
                    alertBinding.editTextUsername.text.toString(),
                    alertBinding.editTextAddress.text.toString(),
                    alertBinding.editTextCareer.text.toString(),
                    false

                )

                viewModel.addData(contact)

                dialog.cancel()
            }


        }


    }
    // TODO relocate listeners and other stuff to functions
}

