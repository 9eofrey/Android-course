package com.example.homework1.presentation.ui.main.contactList.interfaces

import com.example.homework1.data.Contact

interface OnMultiselectItemListener {

    fun onItemSelectionClick(contact: Contact)
    fun deleteSelectedContacts()

}