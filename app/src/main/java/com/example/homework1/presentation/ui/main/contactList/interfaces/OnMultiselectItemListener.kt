package com.example.homework1.presentation.ui.main.contactList.interfaces

import com.example.homework1.data.Contact

interface OnMultiselectItemListener {
    fun onRemoveItemClick(contact: Contact)
    fun onItemSelectionClick(contact: Contact)
}