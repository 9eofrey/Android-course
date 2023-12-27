package com.example.homework1

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.Adapter
import com.example.homework1.databinding.ActivityContactsBinding
import com.example.homework1.databinding.AlertDialogBinding


class ContactsActivity : AppCompatActivity() {
    private val binding: ActivityContactsBinding by lazy{
        ActivityContactsBinding.inflate(layoutInflater)
    }
    private val alertBinding: AlertDialogBinding by lazy{
        AlertDialogBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recycleViewContacts.layoutManager = LinearLayoutManager(this)





        val items = mutableListOf(
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John"),
            Item(R.drawable.ic_launcher_background, "John")

        )


        val adapter = Adapter(items)
        binding.buttonAddContact.setOnClickListener { OnCreateContact()  }
        binding.recycleViewContacts.adapter = adapter



    }

    fun OnCreateContact(){
        val builder = AlertDialog.Builder(this).setView(alertBinding.root).show()
    }


}