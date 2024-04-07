package com.example.homework1.fragments.contacts

import com.example.homework1.model.Contact

interface OnMultiselectItemListener {
    fun onRemoveItemClick(contact: Contact)
    fun onItemSelectionClick(contact: Contact)
}