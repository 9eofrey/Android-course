package com.example.homework1.fragments.contacts

import com.example.homework1.model.Contact

interface ItemClicks {
    fun onItemCLick(position: Int,contact: Contact)
    fun onDeleteItem(position: Int)

    fun onSelectionMode(position: Int)
    fun onClickSelection(position: Int)
    fun onClickDeselection(position: Int)
    fun onDeleteMultipleItems()

}