package com.example.homework1.presentation.ui.main.contactList.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.data.Contact
import com.example.homework1.databinding.FragmentContactsListBinding
import com.example.homework1.databinding.ItemBinding
import com.example.homework1.databinding.MultiselectItemBinding
import com.example.homework1.presentation.ui.main.contactList.ContactsFragment
import com.example.homework1.presentation.ui.main.contactList.interfaces.OnContactItemListener
import com.example.homework1.presentation.ui.main.contactList.interfaces.OnMultiselectItemListener
import com.example.homework1.presentation.uitl.ext.imageLibs
import com.google.android.material.snackbar.Snackbar

class ContactsAdapter(
    val onContactItemListener: OnContactItemListener,
    val onMultiselectItemListener: OnMultiselectItemListener,

    ) : ListAdapter<Contact, ContactsAdapter.MainViewHolder>(
    ContactsDiffCallback()
) {

    var isSelectionOn: Boolean = false


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return if (viewType == ViewHolderType.VIEWHOLDER.ordinal) {
            val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolder(binding)


        } else {
            val binding =
                MultiselectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            MultiselectViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    override fun getItemViewType(position: Int): Int {
        return if (isSelectionOn) {
            ViewHolderType.MULTISELECT_VIEWHOLDER.ordinal
        } else {
            ViewHolderType.VIEWHOLDER.ordinal
        }
    }

    enum class ViewHolderType {
        VIEWHOLDER,
        MULTISELECT_VIEWHOLDER
    }

    fun setMultiselectMode(selection: Boolean) {
        isSelectionOn = selection
    }


    abstract inner class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(contact: Contact)
    }


    inner class ViewHolder(private val binding: ItemBinding) : MainViewHolder(binding.root) {
        override fun bind(contact: Contact) {


            with(binding) {
                buttonRemoveContact.setOnClickListener {
                    onContactItemListener.onDeleteItem(getItem(bindingAdapterPosition))
                    onContactItemListener.onCancelSnackBar(bindingAdapterPosition,getItem(bindingAdapterPosition))
                }

                root.setOnClickListener {
                    onContactItemListener.onItemCLick(bindingAdapterPosition, contact)
                }





                avatarTextView.text = contact.name
                avatarImageView.imageLibs("https://i.pinimg.com/736x/fc/27/fb/fc27fb81e77cc56ba4ed981d7801ceb9.jpg")
                avatarCareer.text = contact.job
                root.setOnLongClickListener {
                    onContactItemListener.onLongItemClick(contact)
                    Log.d("isMultiselect", "Clicked")
                    true
                }
            }
        }
    }

    inner class MultiselectViewHolder(private val itemBinding: MultiselectItemBinding) :
        MainViewHolder(itemBinding.root) {
        override fun bind(contact: Contact) {
            with(itemBinding) {

                // TODO add text and picture(with Glide)
                isCheckedCheckbox.isChecked = contact.isChecked
                isCheckedCheckbox.setOnClickListener {

                    onMultiselectItemListener.onItemSelectionClick(contact)
                }

                itemView.setOnClickListener {
                    onMultiselectItemListener.onItemSelectionClick(contact)
                }

                avatarTextView.text = contact.name
                avatarImageView.imageLibs("https://i.pinimg.com/736x/fc/27/fb/fc27fb81e77cc56ba4ed981d7801ceb9.jpg")
                avatarCareer.text = contact.job

            }


        }
    }

}



