package com.example.prototype_app_non_functional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import com.example.prototype_app_non_functional.R

class PageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)


        val message = intent.getStringExtra("EXTRA_MESSAGE")
        val price = intent.getStringExtra("EXTRA_PRICE")
        val title = intent.getStringExtra("EXTRA_TITLE")
        var image = intent.getIntExtra("EXTRA_IMAGE", 0)

        setTitle(title);
        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.text_item).apply {
            text = message
        }

        val priceview = findViewById<TextView>(R.id.price_text).apply{
            text = price
        }

        var imageview = findViewById<ImageView>(R.id.food_image)
        imageview.setImageResource(image)
        val languages = resources.getStringArray(R.array.qty_array)

        // access the spinner
         val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

        }
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}