package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forlearn.Adapter

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val recyclerView: RecyclerView = findViewById(R.id.recycleViewContacts)
        recyclerView.layoutManager = LinearLayoutManager(this)



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
        recyclerView.adapter = adapter

    }
}