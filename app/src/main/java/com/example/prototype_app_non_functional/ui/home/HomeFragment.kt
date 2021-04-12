package com.example.prototype_app_non_functional.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.prototype_app_non_functional.PageActivity
import com.example.prototype_app_non_functional.R
import com.example.prototype_app_non_functional.ui.gallery.CustomData

class CustomData(var num: Int, var name: String, var price: String, var stock: String)

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_frozen, container, false)
        return root
    }
    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        val list = ArrayList<CustomData>()
        list.add(CustomData(12333, " Rasins", "£1.00", "In-Stock", R.drawable.rasins))
        list.add(CustomData(21324, " Chocolate", "£0.80", "In-Stock", R.drawable.chocolate))
        list.add(CustomData(323423, " Mashed Potatoes", "£3.00", "In-Stock", R.drawable.mashed_potatoes))
        list.add(CustomData(2342344, " Rice", "£1.00", "In-Stock", R.drawable.rice))
        list.add(CustomData(523423, " Pasta (Dried)", "£0.70", "In-Stock", R.drawable.pasta))

        val image = ArrayList<Int>()
        image.add(R.drawable.rasins)
        image.add(R.drawable.chocolate)
        image.add(R.drawable.mashed_potatoes)
        image.add(R.drawable.rice)
        image.add(R.drawable.pasta)


        val listView = view.findViewById<TextView>(R.id.home_list_view) as ListView
        val adapter = activity?.let { ListAdapter(context = it, arrayList = list) }
        listView.adapter = adapter
        listView.setOnItemClickListener{parent, view, position, id ->
            if (position==0){
                val intent = Intent(activity, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                    putExtra("EXTRA_PRICE", list[position].price)
                    putExtra("EXTRA_TITLE", list[position].name)
                    putExtra("EXTRA_IMAGE", image[position])
                }
                startActivity(intent)
            }
            if (position==1){
                val intent = Intent(activity, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                    putExtra("EXTRA_PRICE", list[position].price)
                    putExtra("EXTRA_TITLE", list[position].name)
                    putExtra("EXTRA_IMAGE", image[position])
                }
                startActivity(intent)
            }
            if (position==2){
                val intent = Intent(activity, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                    putExtra("EXTRA_PRICE", list[position].price)
                    putExtra("EXTRA_TITLE", list[position].name)
                    putExtra("EXTRA_IMAGE", image[position])
                }
                startActivity(intent)
            }
            if (position==3){
                val intent = Intent(activity, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                    putExtra("EXTRA_PRICE", list[position].price)
                    putExtra("EXTRA_TITLE", list[position].name)
                    putExtra("EXTRA_IMAGE", image[position])
                }
                startActivity(intent)
            }
            if (position==4){
                val intent = Intent(activity, PageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", list[position].name)
                    putExtra("EXTRA_PRICE", list[position].price)
                    putExtra("EXTRA_TITLE", list[position].name)
                    putExtra("EXTRA_IMAGE", image[position])
                }
                startActivity(intent)
            }
        }
    }
}


class ListAdapter(val context: Context, private val arrayList: ArrayList<CustomData>) : BaseAdapter() {
    private lateinit var serialNum: TextView
    private lateinit var name: TextView
    private lateinit var price: TextView
    private lateinit var stock: TextView
    private lateinit var image: ImageView

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
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        name = convertView.findViewById(R.id.name)
        price = convertView.findViewById(R.id.price)
        stock = convertView.findViewById(R.id.stock)
        image = convertView.findViewById(R.id.mini_food)
        name.text = arrayList[position].name
        price.text = arrayList[position].price
        stock.text =  arrayList[position].stock
        image.setImageResource(arrayList[position].image)
        return convertView
    }
}
