package com.example.homework1.data

object ContactList {
    fun getContactList() = List(33) {
        Contact(
            "Anna",
            "23",
            "designer",
            false
        )
    }
}
