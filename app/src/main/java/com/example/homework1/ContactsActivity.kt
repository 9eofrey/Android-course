package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forlearn.Adapter
import com.example.homework1.databinding.ActivityContactsBinding
import com.example.homework1.databinding.ActivityMainBinding

class ContactsActivity : AppCompatActivity() {
    private val binding: ActivityContactsBinding by lazy{
        ActivityContactsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //val recyclerView: RecyclerView = findViewById(R.id.recycleViewContacts)
        binding.recycleViewContacts.layoutManager = LinearLayoutManager(this)



        val items = listOf(
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