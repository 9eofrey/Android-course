package com.example.homework1
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.Item
import com.example.homework1.R
import android.widget.Toast
class Adapter(private val items: MutableList<Item>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val viewholder=  ViewHolder(view)
        Log.d("viewholder",  "created new viewholder ${viewholder.hashCode()}")
        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        Log.d("bind", "binded viewholder with item $item")
        holder.avatarImageView.setImageResource(item.avatarResId)
        holder.textView.text = item.text
        holder.deleteButton.setOnClickListener {
            onDeleteViewHolder(position, holder)
        }
    }

   private fun onDeleteViewHolder(position: Int, holder: ViewHolder){
        items.removeAt(position)
        Toast.makeText(holder.itemView.context, "contact deleted", Toast.LENGTH_SHORT).show()
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
        val textView: TextView = itemView.findViewById(R.id.avatarTextView)
        val deleteButton = itemView.findViewById<AppCompatButton>(R.id.button_remove_contact)


    }
}
