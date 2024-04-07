package com.example.homework1

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework1.databinding.AlertDialogBinding
import com.example.homework1.databinding.FragmentContactsListBinding
import com.example.homework1.databinding.ItemBinding
import com.example.homework1.ext.SwipeToDelete
import com.example.homework1.fragments.contacts.OnContactItemListener
import com.example.homework1.fragments.contacts.OnMultiselectItemListener
import com.example.homework1.model.Contact
import com.example.homework1.model.ContactViewModel


class ContactsFragment : Fragment() {
    private lateinit var binding: FragmentContactsListBinding
    private lateinit var alertBinding: AlertDialogBinding
    private val viewModel: ContactViewModel by viewModels()
    lateinit var recadapter: ContactsAdapter
    lateinit var navCont: NavController
    lateinit var itemBinding: ItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = FragmentContactsListBinding.inflate(inflater, container, false)
        itemBinding = ItemBinding.inflate(layoutInflater)
        setListeners()
        setAdapter()
        setAlertDialog()

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
        }
    }

    private fun setAdapter() {
        binding.recycleViewContacts.layoutManager = LinearLayoutManager(context)

        binding.recycleViewContacts.SwipeToDelete {
            viewModel.deleteOnPosition(it)
        }

        recadapter = ContactsAdapter(
            onContactItemListener = object : OnContactItemListener {
                override fun onItemCLick(position: Int, contact: Contact) {
                    val directions =
                        HostPagerFragmentDirections.actionHostPagerFragmentToContactDetailFragment(
                            contact
                        )
                    findNavController().navigate(directions)
                }

                override fun onDeleteItem(position: Int) {
                    viewModel.deleteOnPosition(position)

                }

                override fun onLongItemClick(contact: Contact) {
                    viewModel.onSelectionMode(true)
                    viewModel.onItemSelection(contact)
                }
            },
            onMultiselectItemListener = object : OnMultiselectItemListener {
                override fun onRemoveItemClick(contact: Contact) {
                    TODO("Not yet implemented")
                }

                override fun onItemSelectionClick(contact: Contact) {
                    viewModel.onItemSelection(contact)
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
                    1,
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

