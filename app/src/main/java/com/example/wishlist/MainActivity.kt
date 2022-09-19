package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // declare variable "all_wishes" with lateinit (will be initialized in future)
    lateinit var all_wishes: MutableList<Wish>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declare the val of Edit text and button for use in a function
        val name_input = findViewById<EditText>(R.id.nameET)
        val price_input = findViewById<EditText>(R.id.priceET)
        val url_input = findViewById<EditText>(R.id.urlET)
        val add_button = findViewById<Button>(R.id.wishButton)


/*      // function getWish retrieves editText values and add them in "wishes" mutablelist
        // "wishes" is returned
        fun getWish(): MutableList<Wish>{
            val wishes : MutableList<Wish> = ArrayList()
            add_button.setOnClickListener {
                val name= name_input.getText().toString()
                val price= price_input.getText().toString()
                val url= url_input.getText().toString()
                val wishTemp = Wish(name, price, url)
                wishes.add(wishTemp)
            }
            return wishes
        }*/

/*      var wishes : MutableList<Wish> = ArrayList()
        var name= name_input.getText().toString()
        var price= price_input.getText().toString()
        var url= url_input.getText().toString()
        add_button.setOnClickListener {
            wishes.add(Wish(name,url,price))
            print(name)
        }*/




        // declare wishes here because it is needed when "all_wishes=wishes"
        var wishes: MutableList<Wish> = ArrayList()




        // Lookup the RecyclerView in activity layout
        val wishRV = findViewById<RecyclerView>(R.id.wishRV)
        // Fetch the list of emails
        all_wishes = wishes
        // Create adapter passing in the list of emails
        val adapter = WishAdapter(all_wishes)
        // Attach the adapter to the RecyclerView to populate items
        wishRV.adapter = adapter
        // Set layout manager to position the items
        wishRV.layoutManager = LinearLayoutManager(this)


        // SetonClickListener for button which retrieves edittext and adds to object wishes as a list.
        // This is declared after the adapter because notifyDatasetChanged() tells adapter of new change
        add_button.setOnClickListener {
            var name = name_input.text.toString()
            var price = price_input.text.toString()
            var url = url_input.text.toString()
            var wishTemp = Wish(name, price, url)
            wishes.add(wishTemp)
            adapter.notifyDataSetChanged()
        }


    }
}