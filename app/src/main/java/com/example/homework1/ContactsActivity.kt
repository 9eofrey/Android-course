package com.example.homework1

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.Adapter
import com.example.homework1.databinding.ActivityContactsBinding
import com.example.homework1.databinding.AlertDialogBinding


class ContactsActivity : AppCompatActivity() {
    private val binding: ActivityContactsBinding by lazy{
        ActivityContactsBinding.inflate(layoutInflater)
    }
    private lateinit var alertBinding: AlertDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recycleViewContacts.layoutManager = LinearLayoutManager(this)





        val items = emptyList<Item>().toMutableList()


        val adapter = Adapter(items)


        binding.buttonAddContact.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.alert_dialog, null)
            val dialog = AlertDialog.Builder(this).setView(view).show()
            alertBinding = AlertDialogBinding.bind(view)
            alertBinding.buttonSaveContact.setOnClickListener {
                Log.d("clicked","clicked")
                saveContact(items)
                dialog.cancel()
            }


        }







        binding.recycleViewContacts.adapter = adapter




    }
   private fun saveContact(items:MutableList<Item>){
        items.add(Item(R.drawable.ic_launcher_background,alertBinding.editTextUsername.text.toString()))
      val position=   items.indexOfLast { Item->true }
        binding.recycleViewContacts?.adapter?.notifyItemInserted(position)

    }
    fun startF(){
        val fragment =ContactFragment()
        val fm: FragmentManager =supportFragmentManager
        fm.beginTransaction().add(R.id.contacts_layout,fragment).commit()
    }


}