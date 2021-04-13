package com.example.prototype_app_non_functional.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.prototype_app_non_functional.CartActivity
import com.example.prototype_app_non_functional.PageActivity
import com.example.prototype_app_non_functional.R


class CustomData(var num: Int, var name: String, var order: String, var delivery: String)

class testActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        var actionBar = getSupportActionBar()
        val listView = findViewById<TextView>(R.id.order_list_view) as ListView
        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val list = ArrayList<CustomData>()
        list.add(CustomData(12333, "Mr. X", "#000000001", "Estimated-Delivery: Today (13/04/2021) "))

        val adapter = ListAdapter(this, list)
        listView.adapter = adapter

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

class ListAdapter(val context: Context, private val arrayList: ArrayList<CustomData>) : BaseAdapter() {
    private lateinit var serialNum: TextView
    private lateinit var name: TextView
    private lateinit var order: TextView
    private lateinit var delivery: TextView
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
        convertView = LayoutInflater.from(context).inflate(R.layout.order_row, parent, false)
        name = convertView.findViewById(R.id.name)
        order = convertView.findViewById(R.id.order_num)
        delivery = convertView.findViewById(R.id.delivery_date)
        name.text = arrayList[position].name
        order.text = arrayList[position].order
        delivery.text =  arrayList[position].delivery
        return convertView
    }
}
