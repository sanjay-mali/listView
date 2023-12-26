package com.example.lisyview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = intent.getStringExtra("name")
        val location = intent.getStringExtra("location")
        val time = intent.getStringExtra("time")
        val image = intent.getStringExtra("images")


        val images = findViewById<CircleImageView>(R.id.profile_images)
        val appName = findViewById<TextView>(R.id.names)
        val locations = findViewById<TextView>(R.id.locations)
        val times = findViewById<TextView>(R.id.times)
        val des = findViewById<TextView>(R.id.des)

        appName.text = name
        locations.text = location
        times.text = time
        des.text = intent.getStringExtra("des")
        images.setImageResource(image!!.toInt())


    }
}