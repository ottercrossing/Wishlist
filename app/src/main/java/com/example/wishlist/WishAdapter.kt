package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val wishes: List<Wish>) : RecyclerView.Adapter<WishAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: WishAdapter.ViewHolder, position: Int) {
        // Populate data into the item through the holder
        // Get the data model based on position
        val wish = wishes.get(position)
        // Set item views based on views and data model
        holder.nameTextView.text = wish.name
        holder.priceTextView.text = wish.price
        holder.urlTextView.text = wish.url
    }

    override fun getItemCount(): Int {
        return wishes.size
    }


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            nameTextView = itemView.findViewById(R.id.nameTV)
            priceTextView = itemView.findViewById(R.id.priceTV)
            urlTextView = itemView.findViewById(R.id.urlTV)
        }
    }
}