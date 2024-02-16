package com.example.homework1.fragments.contacts.adapterimport android.util.Logimport android.view.LayoutInflaterimport android.view.Viewimport android.view.ViewGroupimport android.widget.ImageViewimport android.widget.TextViewimport androidx.appcompat.widget.AppCompatButtonimport androidx.recyclerview.widget.RecyclerViewimport androidx.navigation.findNavControllerimport androidx.recyclerview.widget.ItemTouchHelperimport com.bumptech.glide.Glideimport com.example.homework1.model.Contactimport com.example.homework1.Rimport com.example.homework1.databinding.AlertDialogBindingimport com.example.homework1.databinding.FragmentContactsListBindingimport com.example.homework1.fragments.contacts.ContactsFragmentimport com.example.homework1.fragments.contacts.ContactsFragmentDirectionsclass Adapter(private var items: List<Contact>, val onDelete: (Int) -> Unit) :    RecyclerView.Adapter<Adapter.ViewHolder>() {    lateinit var abinding: AlertDialogBinding    private lateinit var binding: FragmentContactsListBinding    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)        val viewholder = ViewHolder(view)        val layoutInflater = LayoutInflater.from(parent.context)        abinding = AlertDialogBinding.inflate(layoutInflater, parent, false)        binding = FragmentContactsListBinding.inflate(layoutInflater)        Log.d("viewholder", "created new viewholder ${viewholder.hashCode()}")        return viewholder    }    override fun onBindViewHolder(holder: ViewHolder, position: Int) {        val item = items[position]        Glide.with(holder.avatarImageView)            .load("https://cdn-icons-png.flaticon.com/512/3177/3177440.png")            .into(holder.avatarImageView)        Log.d("bind", "binded viewholder with item $item")        // holder.avatarImageView.setImageResource(item.avatarResId)        holder.textView.text = item.name        holder.deleteButton?.setOnClickListener {            //.startDrag(holder)            //onDeleteContact(position, holder)            onDelete(position)        }        holder.itemView.setOnClickListener {            val direction =                ContactsFragmentDirections.actionContactsListFragmentToContactFragment(                    item.name, item.address, item.job                )            Log.d("Cname", "name")            it.findNavController().navigate(direction)        }    }    fun refreshData(contacts: List<Contact>) {        items = contacts        notifyDataSetChanged()    }    override fun getItemCount(): Int {        return items.size    }    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {        val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)        val textView: TextView = itemView.findViewById(R.id.avatarTextView)        val deleteButton = itemView.findViewById<AppCompatButton>(R.id.button_remove_contact)    }}