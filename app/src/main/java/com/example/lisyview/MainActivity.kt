package com.example.lisyview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import de.hdodenhof.circleimageview.CircleImageView

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {

    private lateinit var appArray: ArrayList<info>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val name = arrayOf("Zomato","Swiggy","Domino's","Drizly","DB")
        val loc = arrayOf("Ahmedabad","Mumbai","Ahmedabad","delhi","Goa")
        val times = arrayOf("10 min","15 min" , "13 min ", "23 min", "8 min")
        val images = intArrayOf(R.drawable.zometo,R.drawable.swiggy,R.drawable.dominos,R.drawable.drizly,R.drawable.db)
        val des = arrayOf("Zomato is an Indian multinational restaurant aggregator and food delivery company founded by Pankaj Chaddah and Deepinder Goyal in 2008. Zomato provides information, menus and user-reviews of restaurants as well as food delivery options from partner restaurants in select cities.",
            "Swiggy is an Indian online food ordering and delivery platform founded in 2014 by Sriharsha Majety, Nandan Reddy and Rahul Jaimini. The company is headquartered in Bangalore, India. Swiggy is inspired by the technology-driven nature of the Silicon Valley companies and wants to build a similar culture in India.",
            "Domino's Pizza, Inc., branded as Domino's, is an American multinational pizza restaurant chain founded in 1960. The corporation is Delaware domiciled and headquartered at the Domino's Farms Office Park in Ann Arbor, Michigan.",
            "Drizly is an alcohol e-commerce platform operating in over 100 markets across the United States and Canada. Users are able to order beer, wine, liquor and extras and have them delivered within 60 minutes.",
            "DB is a German luxury car manufacturer headquartered in Munich, Bavaria. It also owns and produces the Mini marque, and is the parent company of Rolls-Royce Motor Cars. BMW produces motorcycles under BMW Motorrad. In 2012, the BMW Group produced 1,845,186 automobiles and 117,109 motorcycles across all of its brands.")
      //  val data = info(name,loc,times,images)
        appArray = ArrayList()

        for (i in name.indices)
        {
            val data = info(name[i],loc[i],times[i],images[i])

            appArray.add(data)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = Myadapter(this,appArray)

       listView.setOnItemClickListener { parent, view, position, id ->

                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("name",appArray[position].name)
                intent.putExtra("location",appArray[position].location)
                intent.putExtra("time",appArray[position].time)
                intent.putExtra("images",appArray[position].imageId.toString())
                intent.putExtra("des",des[position])
                startActivity(intent)
            }
    }
}