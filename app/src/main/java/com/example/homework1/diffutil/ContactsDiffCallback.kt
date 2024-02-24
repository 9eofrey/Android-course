package com.example.homework1.fragments.contacts.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.homework1.model.Contact

class ContactsDiffCallback: DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}