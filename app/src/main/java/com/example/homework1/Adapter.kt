package com.example.homework1


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.model.Contact
import com.example.homework1.databinding.ItemBinding
import com.example.homework1.databinding.MultiselectItemBinding
import com.example.homework1.ext.imageLibs
import com.example.homework1.fragments.contacts.ItemClicks
import com.example.homework1.diffutil.ContactsDiffCallback

class Adapter(val listener: ItemClicks) : ListAdapter<Contact, Adapter.MainViewHolder>(
    ContactsDiffCallback()
) {
    private var isSelectionOn:Boolean = false
    private var isContactSelected = false



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return if (viewType == ViewHolderType.VIEWHOLDER.ordinal) {
            val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolder(binding)

        } else  {
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

    fun setMultiselectMode(Selection: Boolean) {
       isSelectionOn = Selection
    }


    abstract inner class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(contact: Contact)
    }

    inner class ViewHolder(private val binding: ItemBinding) : MainViewHolder(binding.root) {
        override fun bind(contact: Contact) {

            with(binding) {
                // TODO add text and picture(with Glide)

                buttonRemoveContact.setOnClickListener {
                    listener.onDeleteItem(bindingAdapterPosition)

                }
                root.setOnClickListener{
                    listener.onItemCLick(bindingAdapterPosition)
                }

                avatarTextView.text = contact.name
                avatarImageView.imageLibs("https://svgsilh.com/svg/304080.svg")
                avatarCareer.text = contact.job
                root.setOnLongClickListener{
                    listener.onSelectionMode(bindingAdapterPosition)
                    Log.d("isMultiselect","Clicked")
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

                buttonRemoveContact.setOnClickListener {
                    listener.onDeleteItem(bindingAdapterPosition)

                }

                avatarTextView.text = contact.name
                avatarImageView.imageLibs("https://svgsilh.com/svg/304080.svg")
                avatarCareer.text = contact.job
                if (isSelectionOn){
                    if (isContactSelected){
                        itemView.setOnClickListener {
                            isContactSelected =false
                            listener.onClickDeselection(bindingAdapterPosition)
                            isCheckedItem.visibility =View.GONE
                        }
                    }else{
                        itemView.setOnClickListener {
                            isContactSelected =true
                            listener.onClickSelection(bindingAdapterPosition)
                            isCheckedItem.visibility =View.VISIBLE

                        }
                   }



                }

            }

        }
    }

}



