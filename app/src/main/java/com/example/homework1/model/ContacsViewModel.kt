package com.example.homework1.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework1.model.Contact
import com.example.homework1.R

class ContactViewModel:ViewModel() {


    private val _contacts =MutableLiveData(listOf<Contact>())
    val contacts: LiveData<List<Contact>> = _contacts
    init {
        _contacts.value = listOf(Contact(R.drawable.ic_launcher_background,"Anna","23","designer"))
    }
    fun addData(contact: Contact) {
        val list = _contacts.value?.toMutableList()
        list?.add(contact)
        _contacts.value = list

    }

    fun deleteOnPosition(position: Int) {
        val list = _contacts.value?.toMutableList()
        list?.removeAt(position)
        _contacts.value = list
    }


}
