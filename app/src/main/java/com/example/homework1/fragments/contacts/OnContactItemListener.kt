package com.example.homework1.fragments.contacts

import com.example.homework1.model.Contact

interface OnContactItemListener {
    fun onItemCLick(position: Int,contact: Contact)
    fun onDeleteItem(position: Int)
    fun onLongItemClick(contact: Contact)
}