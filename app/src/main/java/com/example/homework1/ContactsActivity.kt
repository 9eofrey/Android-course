package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.Adapter
import com.example.homework1.databinding.ActivityContactsBinding


class ContactsActivity : AppCompatActivity() {
    private val binding: ActivityContactsBinding by lazy{
        ActivityContactsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val deleteButton = findViewById<AppCompatButton>(R.id.button_remove_contact)

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

        binding.recycleViewContacts.adapter = adapter


    }
}