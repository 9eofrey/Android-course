package com.example.homework1


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.model.Contact
import com.example.homework1.databinding.ItemBinding
import com.example.homework1.ext.imageLibs
import com.example.homework1.fragments.contacts.ItemClicks
import com.example.homework1.fragments.contacts.diffutil.ContactsDiffCallback


class Adapter(val listener: ItemClicks) : ListAdapter<Contact, Adapter.ViewHolder>(ContactsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))



    }


    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            with(binding) {
                // TODO add text and picture(with Glide)
                buttonRemoveContact.setOnClickListener {
                    listener.onDeleteItem(bindingAdapterPosition)

                }
                avatarTextView.text =contact.name
                avatarImageView.imageLibs("https://static.thenounproject.com/png/3237155-200.png")
                avatarCareer.text=contact.job
                itemView.setOnClickListener {
                    listener.onItemCLick(bindingAdapterPosition)
                }

            }
        }

    }


}



