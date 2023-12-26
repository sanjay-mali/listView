package com.example.lisyview

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class Myadapter(private val context: Activity, private val appArray: ArrayList<info>) : ArrayAdapter<info>(context,R.layout.eachitem,appArray)
{
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachitem,null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val appName = view.findViewById<TextView>(R.id.name)
        val location = view.findViewById<TextView>(R.id.location)
        val time = view.findViewById<TextView>(R.id.time)

        appName.text = appArray[position].name
        location.text = appArray[position].location
        time.text = appArray[position].time
        image.setImageResource(appArray[position].imageId)


        return view
    }
}