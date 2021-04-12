package com.example.prototype_app_non_functional

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.text.Selection.setSelection
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.prototype_app_non_functional.ui.gallery.CustomData
import com.example.prototype_app_non_functional.ui.gallery.ListAdapter

class CustomData(var num: Int, var name: String, var price: String, var qty: String)

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val listView = findViewById<TextView>(R.id.cart_list_view) as ListView
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val list = ArrayList<CustomData>()
        list.add(CustomData(12333, "Rasins", "£1.00", "5", R.drawable.rasins))
        list.add(CustomData(21324, "Chocolate", "£0.80", "6", R.drawable.chocolate))
        list.add(CustomData(323423, "Mashed Potatoes", "£3.00", "1", R.drawable.mashed_potatoes))
        list.add(CustomData(2342344, "Rice", "£1.00", "2", R.drawable.rice))
        list.add(CustomData(523423, "Pasta (Dried)", "£0.70", "3", R.drawable.pasta))
        val adapter = ListAdapter(this, list)
        listView.adapter = adapter
        listView.setOnItemClickListener{parent, view, position, id ->
            if (position==0){
                val intent = Intent(this, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                }
                startActivity(intent)
            }
            if (position==1){
                val intent = Intent(this, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                }
                startActivity(intent)
            }
            if (position==2){
                val intent = Intent(this, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                }
                startActivity(intent)
            }
            if (position==3){
                val intent = Intent(this, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                }
                startActivity(intent)
            }
            if (position==4){
                val intent = Intent(this, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                }
                startActivity(intent)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    class ListAdapter(val context: Context, private val arrayList: ArrayList<CustomData>) : BaseAdapter() {
        private lateinit var serialNum: TextView
        private lateinit var name: TextView
        private lateinit var price: TextView
        private lateinit var stock: TextView
        override fun getCount(): Int {
            return arrayList.size
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            var convertView = convertView
            convertView = LayoutInflater.from(context).inflate(R.layout.cart_row, parent, false)
            name = convertView.findViewById(R.id.name)
            price = convertView.findViewById(R.id.price)
            stock = convertView.findViewById(R.id.qty)
            name.text = arrayList[position].name
            price.text = arrayList[position].price
            stock.text =  arrayList[position].stock
            return convertView
        }
    }


}