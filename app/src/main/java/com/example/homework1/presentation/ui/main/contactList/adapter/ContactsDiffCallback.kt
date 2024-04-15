package com.example.homework1.presentation.ui.main.contactList.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.homework1.data.Contact

class ContactsDiffCallback: DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}