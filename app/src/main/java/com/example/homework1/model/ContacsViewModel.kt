package com.example.homework1.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework1.R

class ContactViewModel : ViewModel() {


    private val _contacts = MutableLiveData(listOf<Contact>())
    val contacts: LiveData<List<Contact>> = _contacts
    private val _isSelectedModeOn = MutableLiveData(false)
    val isSelectedModeOn: LiveData<Boolean> = _isSelectedModeOn


    init {
        _contacts.value =
            listOf(Contact(
               avatarResId = 1552,
                "Anna",
                "23",
                "designer",
                false),
                Contact(
                    avatarResId = 1415,
                    name = "Katara",
                    address = "Ramin",
                    job = "Abigail",
                    isChecked = false
                ), Contact(
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

    fun onItemLongClick(position: Int) {
        _isSelectedModeOn.value = true
        _contacts.value = _contacts.value?.toMutableList().apply {
            this?.get(position)?.let {
                this[position] = it.copy(isChecked = true)

            }
        }
       // Log.d("isMultiselect", "OnItemSelected(before) = ${_contacts.value?.get(position)}")
     //   onItemClickSelect(position)
      //  Log.d("isMultiselect", "OnItemSelected(after) = ${_contacts.value}")
    }
    fun onItemClickSelect(position: Int){
                _contacts.value = _contacts.value?.toMutableList().apply {
            this?.get(position)?.let {
                this[position] = it.copy(isChecked = true)

            }
          }
    }
    fun onItemClickDeselect(position: Int){
        _contacts.value = _contacts.value?.toMutableList().apply {
            this?.get(position)?.let {
                this[position] = it.copy(isChecked = false)

            }
        }
    }

fun onDeleteSelectedItems(){
   val list = emptyList<Contact>().toMutableList()
   for(i in _contacts.value!! ) {
       if (i.isChecked) {
           list.add(i)
       }
   }
    list.removeAll(list)
    _contacts.value =list
}


    fun getContact(position: Int): Contact {
        return contacts.value?.get(position) ?: Contact(
            avatarResId = 4475,
            name = "Rami",
            address = "Niketa",
            job = "Lizzette",
            isChecked = true
        )
    }
}


