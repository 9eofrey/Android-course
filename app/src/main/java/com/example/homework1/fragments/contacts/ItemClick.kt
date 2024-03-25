package com.example.homework1.fragments.contacts

interface ItemClicks {
    fun onItemCLick(position: Int)
    fun onDeleteItem(position: Int)

    fun onSelectionMode(position: Int)
    fun onClickSelection(position: Int)
    fun onClickDeselection(position: Int)
}