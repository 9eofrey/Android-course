package com.example.homework1

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework1.model.Contact
import com.example.homework1.ext.SwipeToDelete
import com.example.homework1.databinding.AlertDialogBinding
import com.example.homework1.databinding.FragmentContactsListBinding
import com.example.homework1.fragments.contacts.ItemClicks
import com.example.homework1.model.ContactViewModel


class ContactsFragment : Fragment() {
    private lateinit var binding: FragmentContactsListBinding
    private lateinit var alertBinding: AlertDialogBinding
    private val viewModel: ContactViewModel by viewModels()
    lateinit var Recadapter: Adapter
    lateinit var navCont :NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentContactsListBinding.inflate(inflater, container, false)
        setListeners()
        setAdapter()
        setAlertDialog()
        navCont= findNavController()
        return binding.root

    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()

    }
    fun showToast(){
        // TODO Implement Toast
    }

    private fun setObservers() {
        viewModel.contacts.observe(viewLifecycleOwner) {
            Recadapter.submitList(it)
        }
    }
    private fun setListeners(){

        binding.apply {
            buttonBackNavigation.setOnClickListener {
                it.findNavController().popBackStack()
            }
        }
    }
    private fun setAdapter(){
        binding.recycleViewContacts.layoutManager = LinearLayoutManager(context)

        binding.recycleViewContacts.SwipeToDelete{
            viewModel.deleteOnPosition(it)
        }

        Recadapter = Adapter(object : ItemClicks {
            override fun onItemCLick(position:Int) {
                //navCont.navigate(ContactsFragmentDirections.actionContactsListFragmentToContactFragment())

            }

            override fun onDeleteItem(position: Int) {
                viewModel.deleteOnPosition(position)

            }

        })
        binding.recycleViewContacts.adapter = Recadapter

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
                    R.drawable.ic_launcher_background,
                    alertBinding.editTextUsername.text.toString(),
                    alertBinding.editTextAddress.text.toString(),
                    alertBinding.editTextCareer.text.toString()
                )

                viewModel.addData(contact)

                dialog.cancel()
            }


        }


    }
    // TODO relocate listeners and other stuff to functions
}

