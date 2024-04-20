package com.example.homework1.presentation.ui.main.contactList.interfaces

import com.example.homework1.data.Contact

interface OnContactItemListener {
    fun onItemCLick(position: Int,contact: Contact)
    fun onDeleteItem(contact: Contact)
    fun onLongItemClick(contact: Contact)


}