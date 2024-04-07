package com.example.homework1.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {


    private val _contacts = MutableLiveData(listOf<Contact>())
    val contacts: LiveData<List<Contact>> = _contacts
    private val _isSelectedModeOn = MutableLiveData(false)
    val isSelectedModeOn: LiveData<Boolean> = _isSelectedModeOn


    init {
        _contacts.value =
            listOf(
                Contact(
                    avatarResId = 1552,
                    "Anna",
                    "23",
                    "designer",
                    false
                ),
                Contact(
                    avatarResId = 1415,
                    name = "Katara",
                    address = "Ramin",
                    job = "Abigail",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 1552,
                    "Anna",
                    "23",
                    "designer",
                    false
                ),
                Contact(
                    avatarResId = 1415,
                    name = "Katara",
                    address = "Ramin",
                    job = "Abigail",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 1552,
                    "Anna",
                    "23",
                    "designer",
                    false
                ),
                Contact(
                    avatarResId = 1415,
                    name = "Katara",
                    address = "Ramin",
                    job = "Abigail",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 1552,
                    "Anna",
                    "23",
                    "designer",
                    false
                ),
                Contact(
                    avatarResId = 1415,
                    name = "Katara",
                    address = "Ramin",
                    job = "Abigail",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 1552,
                    "Anna",
                    "23",
                    "designer",
                    false
                ),
                Contact(
                    avatarResId = 1415,
                    name = "Katara",
                    address = "Ramin",
                    job = "Abigail",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 1552,
                    "Anna",
                    "23",
                    "designer",
                    false
                ),
                Contact(
                    avatarResId = 1415,
                    name = "Katara",
                    address = "Ramin",
                    job = "Abigail",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
                Contact(
                    avatarResId = 7952,
                    name = "Reno",
                    address = "Audrina",
                    job = "Towanda",
                    isChecked = false
                ),
            )
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

    fun onSelectionMode(isSelectionModeEnabled: Boolean) {
        _isSelectedModeOn.value = isSelectionModeEnabled
    }

    fun onDeleteSelectedItems() {
        _contacts.value = _contacts.value?.filterNot { it.isChecked }
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
        _contacts.value = _contacts.value?.toMutableList()?.apply {
            this[position] = get(position).copy(isChecked = true)
        }
    }

    private fun onItemClickDeselect(position: Int) {
        _contacts.value = _contacts.value?.toMutableList()?.apply {
            this[position] = get(position).copy(isChecked = false)
        }

        if (contacts.value?.any { it.isChecked } == false) {
            onSelectionMode(false)
        }
    }
}


