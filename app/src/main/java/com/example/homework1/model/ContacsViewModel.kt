package com.example.homework1.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework1.R

class ContactViewModel:ViewModel() {


    private val _contacts =MutableLiveData(listOf<Contact>())
    val contacts: LiveData<List<Contact>> = _contacts
    private val _isSelected =MutableLiveData(false)
    val isSelected: LiveData<Boolean> = _isSelected

    init {
        _contacts.value = listOf(Contact(R.drawable.ic_launcher_background,"Anna","23","designer",false))
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

    fun onItemLongClick(position: Int) {
        _isSelected.value = true
        Log.d("isMultiselect","OnItemSelected(before) = ${_contacts.value?.get(position)}")


        _contacts.value = _contacts.value?.toMutableList().apply {
           this?.get(position)?.let {
               this[position] =  it.copy(isChecked = true)

           }
        }

        Log.d("isMultiselect","OnItemSelected(after) = ${_contacts.value}")

    }

    fun getContact(position: Int):Contact {
        return contacts.value?.get(position)?: Contact(
            avatarResId = 4475,
            name = "Rami",
            address = "Niketa",
            job = "Lizzette",
            isChecked = true
        )
    }


}
