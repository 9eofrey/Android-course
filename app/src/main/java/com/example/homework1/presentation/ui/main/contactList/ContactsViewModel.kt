package com.example.homework1.presentation.ui.main.contactList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework1.data.Contact
import com.example.homework1.data.ContactList

class ContactViewModel : ViewModel() {


    private val _contacts: MutableLiveData<List<Contact>> = MutableLiveData(emptyList<Contact>())
    val contacts: LiveData<List<Contact>> = _contacts
    private val _isSelectedModeOn = MutableLiveData(false)
    val isSelectedModeOn: LiveData<Boolean> = _isSelectedModeOn


    init {
        _contacts.value =
            ContactList.getContactList()
    }

    fun addData(contact: Contact) {
        updateLiveDate { add(contact) }
    }

    private fun updateLiveDate(update: MutableList<Contact>.() -> Unit) {
        _contacts.value = _contacts.value?.toMutableList()?.apply {
            update()
        }

    }

    fun deleteContact(contact: Contact) {
        if (_contacts.value!!.contains(contact)) {
            updateLiveDate { remove(contact) }
        }

    }

    fun onSelectionMode(isSelectionModeEnabled: Boolean) {
        _isSelectedModeOn.value = isSelectionModeEnabled
    }

    fun onDeleteSelectedItems() {
        _contacts.value = _contacts.value?.filterNot { it.isChecked }
    }
    fun deleteOnPosition(position: Int){
        if (position==-1){
            return
        }else {
            updateLiveDate { removeAt(position) }
        }
    }


    fun onItemSelection(contact: Contact) {
        val position = contacts.value?.indexOf(contact)!!
        if (contact.isChecked) {
            onItemClickDeselect(position)
        } else {
            onItemClickSelect(position)
        }
    }

    private fun onItemClickSelect(position: Int) {
        if (position!=-1){
            _contacts.value = _contacts.value?.toMutableList()?.apply {
                this[position] = get(position).copy(isChecked = true)
            }
        }else return

    }

    private fun onItemClickDeselect(position: Int) {
        if (position!=-1){
            _contacts.value = _contacts.value?.toMutableList()?.apply {
                this[position] = get(position).copy(isChecked = false)
            }
        }else return


        if (contacts.value?.any { it.isChecked } == false) {
            onSelectionMode(false)
        }
    }
}


